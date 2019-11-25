package com.shanhai.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.shanhai.dao.MomentDao;
import com.shanhai.model.Moment;

@Controller @Scope("prototype")
public class MomentAction extends ActionSupport {
	@Resource MomentDao momentDao;
	private Moment moment;
	private List<Moment> momentList;
	
	
	public Moment getMoment() {
		return moment;
	}
	
	public void setMoment(Moment moment) {
		this.moment = moment;
	}
	
	public String addMoment() throws Exception{
		momentDao.AddMoment(moment);;
		return "added_moment";
	}
	
	public String showUser() {
		momentList = momentDao.QueryAllMoment();
		return "show_moment";
	}

}
