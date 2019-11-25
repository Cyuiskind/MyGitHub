package com.shanhai.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.shanhai.dao.ComzanDao;
import com.shanhai.model.Comzan;

@Controller @Scope("prototype")
public class ComzanAction extends ActionSupport {
	@Resource ComzanDao comzanDao;
	private Comzan comzan;
	private List<Comzan> comzanList;
	
	
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
