package com.shanhai.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.shanhai.dao.DiscussmakeDao;
import com.shanhai.model.Discussmake;

@Controller @Scope("prototype")
public class DiscussmakeAction extends ActionSupport {
	@Resource DiscussmakeDao discussmakeDao;;
	private Discussmake discussmake;
	private List<Discussmake> discussmakeList;
	
	
	public Discussmake getDiscussmake() {
		return discussmake;
	}
	
	public void setDiscussmake(Discussmake discussmake) {
		this.discussmake = discussmake;
	}
	
	public String addDiscussmake() throws Exception{
		discussmakeDao.AddDiscussmake(discussmake);;
		return "added_discussmake";
	}
	
	public String showDiscussmake() {
		discussmakeList = discussmakeDao.QueryAllDiscussmake();
		return "show_discussmake";
	}

}
