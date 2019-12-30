package com.shanhai.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.shanhai.dao.ComzanDao;
import com.shanhai.dao.MomentDao;
import com.shanhai.model.Comzan;
import com.shanhai.model.Moment;
import com.shanhai.model.User;

@Controller @Scope("prototype")
public class ComzanAction extends ActionSupport implements SessionAware{
	@Resource ComzanDao comzanDao;
	@Resource MomentDao momentDao;
	private Comzan comzan;
	private List<Comzan> comzanList;
	private Map<String,Object> session;
	private Moment moment;
	
	
	
	public ComzanDao getComzanDao() {
		return comzanDao;
	}

	public void setComzanDao(ComzanDao comzanDao) {
		this.comzanDao = comzanDao;
	}

	public List<Comzan> getComzanList() {
		return comzanList;
	}

	public void setComzanList(List<Comzan> comzanList) {
		this.comzanList = comzanList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Comzan getComzan() {
		return comzan;
	}
	
	public void setComzan(Comzan comzan) {
		this.comzan = comzan;
	}
	
	public String addComzan() throws Exception{
		comzanDao.AddComzan(comzan);;
		return "added_comzan";
	}
	
	public String showComzan() {
		comzanList = comzanDao.QueryAllComzan();
		return "show_comzan";
	}
	


}
