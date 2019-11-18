package com.shanhai.action;

import java.util.List;

import javax.annotation.Resource;

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
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String addUser() throws Exception{
		userDao.AddUser(user);
		return "added_user";
	}
	
	public String showUser() {
		userList = userDao.QueryAllUser();
		return "show_user";
	}
	
	public String login() {
		return "success";
	}
	
	public String tomypage() {
		return "mypage";
	}

}
