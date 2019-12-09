package com.shanhai.model;

import java.sql.Time;
import java.util.Date;

/**
 * Comzan entity. @author MyEclipse Persistence Tools
 */

public class Comzan implements java.io.Serializable {

	// Fields

	private Integer czid;
	private Moment moment;
	private User user;
	private String cztype;
	private Integer parentid;
	private Integer czerid;
	private String comtext;
	private String comimag;
	private Time momcztime;
	private Date momczday;

	// Constructors

	/** default constructor */
	public Comzan() {
	}

	/** minimal constructor */
	public Comzan(Moment moment, User user, Integer czerid) {
		this.moment = moment;
		this.user = user;
		this.czerid = czerid;
	}

	/** full constructor */
	public Comzan(Moment moment, User user, String cztype, Integer parentid, Integer czerid, String comtext,
			String comimag, Time momcztime, Date momczday) {
		this.moment = moment;
		this.user = user;
		this.cztype = cztype;
		this.parentid = parentid;
		this.czerid = czerid;
		this.comtext = comtext;
		this.comimag = comimag;
		this.momcztime = momcztime;
		this.momczday = momczday;
	}

	// Property accessors

	public Integer getCzid() {
		return this.czid;
	}

	public void setCzid(Integer czid) {
		this.czid = czid;
	}

	public Moment getMoment() {
		return this.moment;
	}

	public void setMoment(Moment moment) {
		this.moment = moment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCztype() {
		return this.cztype;
	}

	public void setCztype(String cztype) {
		this.cztype = cztype;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getCzerid() {
		return this.czerid;
	}

	public void setCzerid(Integer czerid) {
		this.czerid = czerid;
	}

	public String getComtext() {
		return this.comtext;
	}

	public void setComtext(String comtext) {
		this.comtext = comtext;
	}

	public String getComimag() {
		return this.comimag;
	}

	public void setComimag(String comimag) {
		this.comimag = comimag;
	}

	public Time getMomcztime() {
		return this.momcztime;
	}

	public void setMomcztime(Time momcztime) {
		this.momcztime = momcztime;
	}

	public Date getMomczday() {
		return this.momczday;
	}

	public void setMomczday(Date momczday) {
		this.momczday = momczday;
	}

}