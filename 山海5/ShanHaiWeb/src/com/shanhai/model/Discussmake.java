package com.shanhai.model;

import java.sql.Time;
import java.util.Date;

/**
 * Discussmake entity. @author MyEclipse Persistence Tools
 */

public class Discussmake implements java.io.Serializable {

	// Fields

	private Integer disid;
	private User user;
	private String discontent;
	private Date dismakeday;
	private Time dismaketime;
	private Integer postnum;

	// Constructors

	/** default constructor */
	public Discussmake() {
	}

	/** full constructor */
	public Discussmake(User user, String discontent, Date dismakeday, Time dismaketime, Integer postnum) {
		this.user = user;
		this.discontent = discontent;
		this.dismakeday = dismakeday;
		this.dismaketime = dismaketime;
		this.postnum = postnum;
	}

	// Property accessors

	public Integer getDisid() {
		return this.disid;
	}

	public void setDisid(Integer disid) {
		this.disid = disid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDiscontent() {
		return this.discontent;
	}

	public void setDiscontent(String discontent) {
		this.discontent = discontent;
	}

	public Date getDismakeday() {
		return this.dismakeday;
	}

	public void setDismakeday(Date dismakeday) {
		this.dismakeday = dismakeday;
	}

	public Time getDismaketime() {
		return this.dismaketime;
	}

	public void setDismaketime(Time dismaketime) {
		this.dismaketime = dismaketime;
	}

	public Integer getPostnum() {
		return this.postnum;
	}

	public void setPostnum(Integer postnum) {
		this.postnum = postnum;
	}

}