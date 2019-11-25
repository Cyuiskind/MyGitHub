package com.shanhai.model;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Moment entity. @author MyEclipse Persistence Tools
 */

public class Moment implements java.io.Serializable {

	// Fields

	private Integer momentid;
	private User user;
	private String momenttype;
	private Integer momparentid;
	private Date momentday;
	private Time momenttime;
	private String comentcontent;
	private String momentimg1;
	private String momentimg2;
	private String momentimg3;
	private String momentimg4;
	private String momentimg5;
	private String momentimg6;
	private String momentimg7;
	private String momentimg8;
	private String momentimg9;
	private String video1;
	private String video2;
	private String video3;
	private Integer likenum;
	private Integer commentnum;
	private Integer sharenum;
	private Set comzans = new HashSet(0);

	// Constructors

	/** default constructor */
	public Moment() {
	}

	/** minimal constructor */
	public Moment(User user) {
		this.user = user;
	}

	/** full constructor */
	public Moment(User user, String momenttype, Integer momparentid, Date momentday, Time momenttime,
			String comentcontent, String momentimg1, String momentimg2, String momentimg3, String momentimg4,
			String momentimg5, String momentimg6, String momentimg7, String momentimg8, String momentimg9,
			String video1, String video2, String video3, Integer likenum, Integer commentnum, Integer sharenum,
			Set comzans) {
		this.user = user;
		this.momenttype = momenttype;
		this.momparentid = momparentid;
		this.momentday = momentday;
		this.momenttime = momenttime;
		this.comentcontent = comentcontent;
		this.momentimg1 = momentimg1;
		this.momentimg2 = momentimg2;
		this.momentimg3 = momentimg3;
		this.momentimg4 = momentimg4;
		this.momentimg5 = momentimg5;
		this.momentimg6 = momentimg6;
		this.momentimg7 = momentimg7;
		this.momentimg8 = momentimg8;
		this.momentimg9 = momentimg9;
		this.video1 = video1;
		this.video2 = video2;
		this.video3 = video3;
		this.likenum = likenum;
		this.commentnum = commentnum;
		this.sharenum = sharenum;
		this.comzans = comzans;
	}

	// Property accessors

	public Integer getMomentid() {
		return this.momentid;
	}

	public void setMomentid(Integer momentid) {
		this.momentid = momentid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMomenttype() {
		return this.momenttype;
	}

	public void setMomenttype(String momenttype) {
		this.momenttype = momenttype;
	}

	public Integer getMomparentid() {
		return this.momparentid;
	}

	public void setMomparentid(Integer momparentid) {
		this.momparentid = momparentid;
	}

	public Date getMomentday() {
		return this.momentday;
	}

	public void setMomentday(Date momentday) {
		this.momentday = momentday;
	}

	public Time getMomenttime() {
		return this.momenttime;
	}

	public void setMomenttime(Time momenttime) {
		this.momenttime = momenttime;
	}

	public String getComentcontent() {
		return this.comentcontent;
	}

	public void setComentcontent(String comentcontent) {
		this.comentcontent = comentcontent;
	}

	public String getMomentimg1() {
		return this.momentimg1;
	}

	public void setMomentimg1(String momentimg1) {
		this.momentimg1 = momentimg1;
	}

	public String getMomentimg2() {
		return this.momentimg2;
	}

	public void setMomentimg2(String momentimg2) {
		this.momentimg2 = momentimg2;
	}

	public String getMomentimg3() {
		return this.momentimg3;
	}

	public void setMomentimg3(String momentimg3) {
		this.momentimg3 = momentimg3;
	}

	public String getMomentimg4() {
		return this.momentimg4;
	}

	public void setMomentimg4(String momentimg4) {
		this.momentimg4 = momentimg4;
	}

	public String getMomentimg5() {
		return this.momentimg5;
	}

	public void setMomentimg5(String momentimg5) {
		this.momentimg5 = momentimg5;
	}

	public String getMomentimg6() {
		return this.momentimg6;
	}

	public void setMomentimg6(String momentimg6) {
		this.momentimg6 = momentimg6;
	}

	public String getMomentimg7() {
		return this.momentimg7;
	}

	public void setMomentimg7(String momentimg7) {
		this.momentimg7 = momentimg7;
	}

	public String getMomentimg8() {
		return this.momentimg8;
	}

	public void setMomentimg8(String momentimg8) {
		this.momentimg8 = momentimg8;
	}

	public String getMomentimg9() {
		return this.momentimg9;
	}

	public void setMomentimg9(String momentimg9) {
		this.momentimg9 = momentimg9;
	}

	public String getVideo1() {
		return this.video1;
	}

	public void setVideo1(String video1) {
		this.video1 = video1;
	}

	public String getVideo2() {
		return this.video2;
	}

	public void setVideo2(String video2) {
		this.video2 = video2;
	}

	public String getVideo3() {
		return this.video3;
	}

	public void setVideo3(String video3) {
		this.video3 = video3;
	}

	public Integer getLikenum() {
		return this.likenum;
	}

	public void setLikenum(Integer likenum) {
		this.likenum = likenum;
	}

	public Integer getCommentnum() {
		return this.commentnum;
	}

	public void setCommentnum(Integer commentnum) {
		this.commentnum = commentnum;
	}

	public Integer getSharenum() {
		return this.sharenum;
	}

	public void setSharenum(Integer sharenum) {
		this.sharenum = sharenum;
	}

	public Set getComzans() {
		return this.comzans;
	}

	public void setComzans(Set comzans) {
		this.comzans = comzans;
	}

}