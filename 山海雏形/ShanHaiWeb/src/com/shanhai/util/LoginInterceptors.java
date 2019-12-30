package com.shanhai.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.shanhai.model.User;

public class LoginInterceptors extends AbstractInterceptor{

	
	private static final long serialVersionUID = 1L;
	private String sessionName;//传递信息
	private String excludeName;//例外action
	private List<String> list;
	
	
	
	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getExcludeName() {
		return excludeName;
	}

	public void setExcludeName(String excludeName) {
		this.excludeName = excludeName;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public List<String>  strlsit(String str){
		String[] s = str.split(",");
		List <String> list = new ArrayList <String>();
		for(String ss : s) {
			list.add(ss.trim());
		}
		return list;
	}
	
	public void init() {
		list = strlsit(excludeName);
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception{
		System.out.println("-------进入拦截器------------");
		String actionName= invocation.getProxy().getActionName();
		Map <String,Object> session = invocation.getInvocationContext().getSession();
		
		if(list.contains(actionName)) {
			System.out.println(actionName+"没有被拦截");
			session.put("prePage", "/moment/moment_showMoment");
			return invocation.invoke();
		}else {
			System.out.println(actionName+"被拦截了");
		
			User user=(User)session.get(sessionName);			
			if(user==null) {
				System.out.println("&&&&&&&&&&");
				HttpServletRequest req= ServletActionContext.getRequest();
				
				String path=req.getRequestURI().replaceAll("/ShanHaiWeb","");
				System.out.println("path:"+path);
				session.put("prePage", path);
				return "login";
			}else {
				System.out.println("*********");
				System.out.println(user.getUsername());
				return invocation.invoke();
				}
		}
	}

}
