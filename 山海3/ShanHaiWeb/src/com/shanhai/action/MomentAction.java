package com.shanhai.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.shanhai.dao.MomentDao;
import com.shanhai.dao.UserDao;
import com.shanhai.model.Moment;
import com.shanhai.model.User;

@Controller @Scope("prototype")
public class MomentAction extends ActionSupport {
	@Resource MomentDao momentDao;
	@Resource UserDao userDao;
	private Moment moment;
	private List<Moment> momentList;
	private User user;
	
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
	
	public String postMoment() throws Exception{
		user = userDao.QueryUserInfo("Edgar").get(0);
		moment.setUser(user);
		moment.setMomenttype("moment");
		momentDao.AddMoment(moment);
		return "added_moment";
	}
	
	public String showUser() {
		momentList = momentDao.QueryAllMoment();
		return "show_moment";
	}

}
