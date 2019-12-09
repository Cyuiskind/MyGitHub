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
	
	public String postMoment() throws Exception{
		user = userDao.QueryUserInfo("Edgar").get(0);
		moment.setUser(user);
		moment.setMomenttype("moment");
		momentDao.AddMoment(moment);
		return "added_moment";
	}
	
	public String showMoment() {
		momentList = momentDao.QueryAllMoment();
		if(momentList!=null)
			return "show_moment";
		else
			return "input";
	}
	
	public String dianzan() {
		moment = momentDao.GetMomentById(moment.getMomentid());
		moment.setLikenum(moment.getLikenum()+1);
		return "zan";
	}
	
	public String pinglun() {
		moment = momentDao.GetMomentById(moment.getMomentid());
		moment.setCommentnum(moment.getCommentnum()+1);
		return "pinglun";
	}
	
	public String showDetail() {
    	moment = momentDao.GetMomentById(moment.getMomentid());
    	return "detail_view";
    }
    ;
    public String showEdit() throws Exception{
    	moment = momentDao.GetMomentById(moment.getMomentid());
    	return "edit_view";
    }

    public String editMoment() throws Exception{
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
		return "show_view";
		
	}
}
