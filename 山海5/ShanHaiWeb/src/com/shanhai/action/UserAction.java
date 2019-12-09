package com.shanhai.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.shanhai.dao.UserDao;
import com.shanhai.model.User;

@Controller @Scope("prototype")
public class UserAction extends ActionSupport {
	@Resource UserDao userDao;
	private User user;
	private List<User> userList;
	private Integer userid; 
	
	
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
		userDao.AddUser(user);
		return "added_user";
	}
	
	public String showUser() {
		userList = userDao.QueryAllUser();
		if(userList!=null)
			return "show_user";
		else
			return "mypage";
	}
	
	public String login() {
		userList = userDao.QueryAllUser();
		for(User us : userList) {
			if(us.getUsername().equals(user.getUsername())) {
				if(us.getUpassword().equals(user.getUpassword()))
					return "succlog";
				else
					return "faillog";
			}
		}	
		return "wrongname";
	}
	
	public String mypage() {
		return "mypage";
	}

}
