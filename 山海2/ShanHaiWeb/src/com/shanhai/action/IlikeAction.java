package com.shanhai.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.shanhai.dao.IlikeDao;
import com.shanhai.model.Ilike;

@Controller @Scope("prototype")
public class IlikeAction extends ActionSupport {
	@Resource IlikeDao ilikeDao;
	private Ilike ilike;
	private List<Ilike> ilikeList;
	
	
	public Ilike getIlike() {
		return ilike;
	}
	
	public void setIlike(Ilike ilike) {
		this.ilike = ilike;
	}
	
	public String addIlike() throws Exception{
		ilikeDao.AddIlike(ilike);;
		return "added_ilike";
	}
	
	public String showIlike() {
		ilikeList = ilikeDao.QueryAllIlike();
		return "show_ilike";
	}

}
