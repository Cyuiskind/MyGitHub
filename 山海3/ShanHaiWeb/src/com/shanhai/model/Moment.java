package com.shanhai.model;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Moment entity. @author MyEclipse Persistence Tools
 */

public class Moment{

	// Fields

	private Integer momentid;
	private User user;
	private String momenttype;
	private Integer momparentid;
	private Date momentday;
	private Time momenttime;
	private String comentcontent;
	private byte[] momentimg1;
	private byte[] momentimg2;
	private byte[] momentimg3;
	private byte[] momentimg4;
	private byte[] momentimg5;
	private byte[] momentimg6;
	private byte[] momentimg7;
	private byte[] momentimg8;
	private byte[] momentimg9;
	private byte[] video1;
	private byte[] video2;
	private byte[] video3;
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
			String comentcontent, byte[] momentimg1, byte[] momentimg2, byte[] momentimg3, byte[] momentimg4,
			byte[] momentimg5, byte[] momentimg6, byte[] momentimg7, byte[] momentimg8, byte[] momentimg9,
			byte[] video1, byte[] video2, byte[] video3, Integer likenum, Integer commentnum, Integer sharenum,
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

	public byte[] getMomentimg1() {
		return this.momentimg1;
	}

	public void setMomentimg1(byte[] momentimg1) {
		this.momentimg1 = momentimg1;
	}

	public byte[] getMomentimg2() {
		return this.momentimg2;
	}

	public void setMomentimg2(byte[] momentimg2) {
		this.momentimg2 = momentimg2;
	}

	public byte[] getMomentimg3() {
		return this.momentimg3;
	}

	public void setMomentimg3(byte[] momentimg3) {
		this.momentimg3 = momentimg3;
	}

	public byte[] getMomentimg4() {
		return this.momentimg4;
	}

	public void setMomentimg4(byte[] momentimg4) {
		this.momentimg4 = momentimg4;
	}

	public byte[] getMomentimg5() {
		return this.momentimg5;
	}

	public void setMomentimg5(byte[] momentimg5) {
		this.momentimg5 = momentimg5;
	}

	public byte[] getMomentimg6() {
		return this.momentimg6;
	}

	public void setMomentimg6(byte[] momentimg6) {
		this.momentimg6 = momentimg6;
	}

	public byte[] getMomentimg7() {
		return this.momentimg7;
	}

	public void setMomentimg7(byte[] momentimg7) {
		this.momentimg7 = momentimg7;
	}

	public byte[] getMomentimg8() {
		return this.momentimg8;
	}

	public void setMomentimg8(byte[] momentimg8) {
		this.momentimg8 = momentimg8;
	}

	public byte[] getMomentimg9() {
		return this.momentimg9;
	}

	public void setMomentimg9(byte[] momentimg9) {
		this.momentimg9 = momentimg9;
	}

	public byte[] getVideo1() {
		return this.video1;
	}

	public void setVideo1(byte[] video1) {
		this.video1 = video1;
	}

	public byte[] getVideo2() {
		return this.video2;
	}

	public void setVideo2(byte[] video2) {
		this.video2 = video2;
	}

	public byte[] getVideo3() {
		return this.video3;
	}

	public void setVideo3(byte[] video3) {
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