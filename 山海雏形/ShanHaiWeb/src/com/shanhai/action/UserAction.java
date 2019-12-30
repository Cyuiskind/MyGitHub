package com.shanhai.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shanhai.dao.MomentDao;
import com.shanhai.dao.UserDao;
import com.shanhai.model.Moment;
import com.shanhai.model.User;

@Controller @Scope("prototype")
public class UserAction extends ActionSupport implements SessionAware {
	@Resource UserDao userDao;
	@Resource MomentDao momentDao;
	private User user;
	private List<User> userList;
	private Integer userid; 
	private Map<String,Object> session;
	private String errMessage;
	private String prePage;
	private List<Moment> momentList;
	
	private String nowuser;
	
    private File profile;
    private File pagephoto;
    private String pagephotoFileName;
    private String pagephotoContentType;
    private String profileFileName;
    private String profileContentType;
	
	
	
	
	
	public File getProfile() {
		return profile;
	}

	public void setProfile(File profile) {
		this.profile = profile;
	}

	public File getPagephoto() {
		return pagephoto;
	}

	public void setPagephoto(File pagephoto) {
		this.pagephoto = pagephoto;
	}

	public String getPagephotoFileName() {
		return pagephotoFileName;
	}

	public void setPagephotoFileName(String pagephotoFileName) {
		this.pagephotoFileName = pagephotoFileName;
	}

	public String getPagephotoContentType() {
		return pagephotoContentType;
	}

	public void setPagephotoContentType(String pagephotoContentType) {
		this.pagephotoContentType = pagephotoContentType;
	}

	public String getProfileFileName() {
		return profileFileName;
	}

	public void setProfileFileName(String profileFileName) {
		this.profileFileName = profileFileName;
	}

	public String getProfileContentType() {
		return profileContentType;
	}

	public void setProfileContentType(String profileContentType) {
		this.profileContentType = profileContentType;
	}

	public String getNowuser() {
		return nowuser;
	}

	public void setNowuser(String nowuser) {
		this.nowuser = nowuser;
	}

	public List<Moment> getMomentList() {
		return momentList;
	}

	public void setMomentList(List<Moment> momentList) {
		this.momentList = momentList;
	}

	public String getPrePage() {
		return prePage;
	}

	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public User getUser() {
		return user;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String addUser() throws Exception{
		if(user==null)
			System.out.println("没传用户过来");
		else
			System.out.println("用户没问题啊");
		user.setPageimg("images/民族美景黄.jpeg");
		user.setUserplace("未知");
		user.setSelfintro("Ta很懒，什么都没写");
		user.setUserimg("images/logo.png");
		user.setUserclass("初级传承者");
		userDao.AddUser(user);
		session.put("user", user);
		return "added_user";
	}
	
	public String showUser() {
		userList = userDao.QueryAllUser();
		if(userList!=null)
			return "show_user";
		else
			return "mypage";
	}
	
	public String showone() {
		user = (User)userDao.GetUserById(user.getUserid());
		momentList = momentDao.TheMoments(user.getUserid());
		User user2 = (User)session.get("user");
		nowuser=user2.getUsername();
		System.out.println(user2.getUsername()+"****");
		System.out.println(user.getUsername()+"******");
		return "onepage";
	}
	
	public String showeditself() {
		user = (User)userDao.GetUserById(user.getUserid());
		session.put("euser",user);
		return "show_eselfview";
	}
	
	public String logout() {
		session.remove("user");
		return "succlog";
	}
	
	public String editself() throws Exception {
	       /*处理图片上传*/
			String path = ServletActionContext.getServletContext().getRealPath("/upload"); 
	        String PhotoFileName = ""; 
	   	 	User user1 =new User((User)session.get("euser"));
	   	 	user.editfrom(user1);
	   	 	if(profile!= null) {
	   	 		InputStream is = new FileInputStream(profile);
	   			String fileContentType = this.getProfileContentType();
	   			System.out.println(fileContentType);
	   			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
	   				PhotoFileName = UUID.randomUUID().toString() +  ".jpg";
	   			else if(fileContentType.equals("image/gif"))
	   				PhotoFileName = UUID.randomUUID().toString() +  ".gif";
	   			else if(fileContentType.equals("image/png"))
	   				PhotoFileName = UUID.randomUUID().toString() +  ".png";

	   			File file = new File(path, PhotoFileName);
	   			file.createNewFile();
	   			System.out.println(file.getName());
	   			System.out.println(file.getAbsolutePath());
	   			System.out.println("存在？"+file.exists());
	   			OutputStream os = new FileOutputStream(file);
	   			byte[] b = new byte[1024];
	   			int bs = 0;
	   	      while ((bs = is.read(b)) != -1) {
	   	    	  System.out.println("正在写入");
	   	        os.write(b,0,bs);
	   	      }if(profile== null) {
	          	System.out.println("文件没传过来");
	          }
	 /*  			while ((bs = is.read(b)) > 0) {
	   				os.write(b, 0, bs);
	   			}*/
	   			is.close();
	   			os.close();
	        	user.setUserimg("upload/" + file.getName());
	        	System.out.println("upload/" + file.getName());
	   	 	}else {
	   	 		user.setUserimg(user1.getUserimg());
	   	 	}
	   	 	
	   	 	if(pagephoto!= null) {
	   	 		InputStream is = new FileInputStream(pagephoto);
	   			String fileContentType = this.getProfileContentType();
	   			System.out.println(fileContentType);
	   			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
	   				PhotoFileName = UUID.randomUUID().toString() +  ".jpg";
	   			else if(fileContentType.equals("image/gif"))
	   				PhotoFileName = UUID.randomUUID().toString() +  ".gif";
	   			else if(fileContentType.equals("image/png"))
	   				PhotoFileName = UUID.randomUUID().toString() +  ".png";

	   			File file = new File(path, PhotoFileName);
	   			file.createNewFile();
	   			System.out.println(file.getName());
	   			System.out.println(file.getAbsolutePath());
	   			System.out.println("存在？"+file.exists());
	   			OutputStream os = new FileOutputStream(file);
	   			byte[] b = new byte[1024];
	   			int bs = 0;
	   	      while ((bs = is.read(b)) != -1) {
	   	    	  System.out.println("正在写入");
	   	        os.write(b,0,bs);
	   	      }if(pagephoto== null) {
	          	System.out.println("文件没传过来");
	          }
	 /*  			while ((bs = is.read(b)) > 0) {
	   				os.write(b, 0, bs);
	   			}*/
	   			is.close();
	   			os.close();
	        	user.setPageimg("upload/" + file.getName());
	        	System.out.println("upload/" + file.getName());
	   	 	}else {
	   	 		user.setPageimg(user1.getUserimg());
	   	 	}
	   	 	session.remove("euser");
	   	 	session.remove("user");
	   	   session.put("user", user);
	    	userDao.UpdateUser(user);		
		return "editedself";
	}
	

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	public String login() {
		ArrayList<User> listUser = userDao.QueryUserInfo(user.getUsername());
		if(listUser.size()==0) { 
			this.errMessage = " 账号不存在 ";
			System.out.print(this.errMessage);
			return "input";
			
		} 
		else{
			User db_user = (User)userDao.QueryUserInfo(user.getUsername()).get(0);
			if(!db_user.getUpassword().equals(user.getUpassword())) {		
				this.errMessage = " 密码不正确! ";
				System.out.print(this.errMessage);
				return "input";	
		    }else{
		    	System.out.println(db_user.getUserimg());
		    	System.out.println(db_user.getUserid());
		    	System.out.println(db_user.getUsername());
		    	System.out.println(db_user.getUserplace());
		    	session.put("user", db_user);
				prePage=(String)session.get("prePage");
				System.out.println("将要跳到:"+prePage);
				session.remove(prePage);
				return "show_view";
		    }
		}
	}
	
	public String mypage() {
		return "mypage";
	}

}
