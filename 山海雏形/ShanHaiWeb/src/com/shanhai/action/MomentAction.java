package com.shanhai.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.shanhai.dao.ComzanDao;
import com.shanhai.dao.MomentDao;
import com.shanhai.dao.UserDao;
import com.shanhai.model.Comzan;
import com.shanhai.model.Moment;
import com.shanhai.model.User;

@Controller @Scope("prototype")
public class MomentAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource MomentDao momentDao;
	@Resource UserDao userDao;
	@Resource ComzanDao comzanDao;
	private Moment moment;
	private List<Moment> momentList;
	private User user;
	private Map<String,Object> session;
	private File mPhoto1;
	private String mPhoto1Filename;
	private String mPhoto1ContentType;
	

	


	public File getMPhoto1() {
		return mPhoto1;
	}

	public void setMPhoto1(File mPhoto1) {
		this.mPhoto1 = mPhoto1;
	}

	public String getMPhoto1Filename() {
		return mPhoto1Filename;
	}

	public void setMPhoto1Filename(String mPhoto1Filename) {
		this.mPhoto1Filename = mPhoto1Filename;
	}

	private Comzan zan = new Comzan();
    
    
    

	
	public Comzan getZan() {
		return zan;
	}

	public void setZan(Comzan zan) {
		this.zan = zan;
	}

	public String getMPhoto1ContentType() {
		return mPhoto1ContentType;
	}

	public void setMPhoto1ContentType(String mPhoto1ContentType) {
		this.mPhoto1ContentType = mPhoto1ContentType;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<Moment> getMomentList() {
		return momentList;
	}

	public void setMomentList(List<Moment> momentList) {
		this.momentList = momentList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Moment getMoment() {
		return moment;
	}
	
	public void setMoment(Moment moment) {
		this.moment = moment;
	}
	
	String comentcontent;
	String title;
	
	
	public String getComentcontent() {
		return comentcontent;
	}

	public void setComentcontent(String comentcontent) {
		this.comentcontent = comentcontent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String postMoment() throws Exception{
		//Moment moment =  new Moment();
		User user=(User)session.get("user");
		user = userDao.QueryUserInfo(user.getUsername()).get(0);
		if(user==null) {
			System.out.println("Session失败");
		}else {
			System.out.println(user.getUpassword());
			System.out.println(user.getUsername());
			System.out.println("没问题啊");
		}
		if(moment==null) {
			System.out.println("瞬间没传过来");
		}else {
			System.out.println("瞬间也没问题啊");
		}
	//	moment.setComentcontent(comentcontent);
	//	moment.setTitle(title);
		
		
        /*处理图片上传*/
		String path = ServletActionContext.getServletContext().getRealPath("/upload"); 
    //    String mPhotoFile1Name = ""; 
        if(mPhoto1== null) {
        	System.out.println("文件没传过来");
        }
   	 	if(mPhoto1!= null) {
   	 		InputStream is = new FileInputStream(mPhoto1);
   			String fileContentType = this.getMPhoto1ContentType();
   			System.out.println(fileContentType);
   			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
   				mPhoto1Filename = UUID.randomUUID().toString() +  ".jpg";
   			else if(fileContentType.equals("image/gif"))
   				mPhoto1Filename = UUID.randomUUID().toString() +  ".gif";
   			else if(fileContentType.equals("image/png"))
   				mPhoto1Filename = UUID.randomUUID().toString() +  ".png";

   			File file = new File(path, mPhoto1Filename);
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
   	      }
 /*  			while ((bs = is.read(b)) > 0) {
   				os.write(b, 0, bs);
   			}*/
   			is.close();
   			os.close();
        	moment.setMomentimg1("upload/" + file.getName());
        	System.out.println("upload/" + file.getName());
   	 	}
        else
        	moment.setMomentimg1("upload/NoImage.jpg");  
        
		moment.setUser(user);
		moment.setLikenum(0);
		moment.setSharenum(0);
		moment.setCommentnum(0);
		moment.setMomenttype("moment");
		momentDao.AddMoment(moment);
		return "added_moment";
	}
	
	public String beforePostMoment() {
		return "before";
	}
	
	public String showMoment() {
		momentList = momentDao.QueryAllMoment();
		if(momentList!=null)
			return "show_moment";
		else
			return "input";
	}
	
	public String dianzan() throws Exception {
		moment = momentDao.GetMomentById(moment.getMomentid());
		moment.setLikenum(moment.getLikenum()+1);
		momentDao.UpdateMoment(moment);
		return "zan";
	}
	
	public String share() throws Exception {
		moment = momentDao.GetMomentById(moment.getMomentid());
		return "succshare";
	}

	
	public String pinglun() throws Exception {
		moment = momentDao.GetMomentById(moment.getMomentid());
		moment.setCommentnum(moment.getCommentnum()+1);
		momentDao.UpdateMoment(moment);
		return "pinglun";
	}
	
	public String showDetail() {
		User user=(User)session.get("user");
		user = userDao.QueryUserInfo(user.getUsername()).get(0);
    	moment = momentDao.GetMomentById(moment.getMomentid());
    	return "detail_view";
    }
    public String showEdit() throws Exception{
    	moment = momentDao.GetMomentById(moment.getMomentid());
    	session.put("emoment", moment);
    	return "edit_view";
    }

    public String editMoment() throws Exception{
        /*处理图片上传*/
		String path = ServletActionContext.getServletContext().getRealPath("/upload"); 
        String mPhoto1FileName = ""; 
   	 	Moment moment1 =new Moment((Moment)session.get("emoment"));
   	 	moment.editfrom(moment1);
   	 	if(mPhoto1!= null) {
   	 		InputStream is = new FileInputStream(mPhoto1);
   			String fileContentType = this.getMPhoto1ContentType();
   			System.out.println(fileContentType);
   			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
   				mPhoto1FileName = UUID.randomUUID().toString() +  ".jpg";
   			else if(fileContentType.equals("image/gif"))
   				mPhoto1FileName = UUID.randomUUID().toString() +  ".gif";
   			else if(fileContentType.equals("image/png"))
   				mPhoto1FileName = UUID.randomUUID().toString() +  ".png";

   			File file = new File(path, mPhoto1FileName);
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
   	      }if(mPhoto1== null) {
          	System.out.println("文件没传过来");
          }
 /*  			while ((bs = is.read(b)) > 0) {
   				os.write(b, 0, bs);
   			}*/
   			is.close();
   			os.close();
        	moment.setMomentimg1("upload/" + file.getName());
        	System.out.println("upload/" + file.getName());
   	 	}else {
   	 		moment.setMomentimg1(moment1.getMomentimg1());
   	 	}
   	 	session.remove("emoment");
    	momentDao.UpdateMoment(moment);
    	return "edit_message";
    }
    
    public String deleteMoment() throws Exception{
    	momentDao.DeleteMoment(moment.getMomentid());
    	return "delete_message";
    }
    
    private String keyWords;

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
    
	public String queryMoments() throws Exception {
		momentList = momentDao.QueryMomentInfo(keyWords);
		return "show_moment";
		
	}
}
