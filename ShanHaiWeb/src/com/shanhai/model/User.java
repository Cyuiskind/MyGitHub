package com.shanhai.model;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String username;
	private String upassword;
	private String phonenum;
	private String userclass;
	private String userimg;
	private String selfintro;
	private String userplace;
	private String pageimg;
	private Integer likenum=0;
	private Integer fannum=0;
	private Integer photonum=0;
	private Integer videonum=0;
	private Integer contactnum=0;
	private Integer momentnum=0;
	private Set moments = new HashSet(0);
	private Set ilikesForLikerid = new HashSet(0);
	private Set discussmakes = new HashSet(0);
	private Set comzans = new HashSet(0);
	private Set ilikesForLikedid = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String upassword, String phonenum, String userclass, String userimg, Integer likenum,
			Integer fannum, Integer photonum, Integer videonum, Integer contactnum, Integer momentnum) {
		this.username = username;
		this.upassword = upassword;
		this.phonenum = phonenum;
		this.userclass = userclass;
		this.userimg = userimg;
		this.likenum = likenum;
		this.fannum = fannum;
		this.photonum = photonum;
		this.videonum = videonum;
		this.contactnum = contactnum;
		this.momentnum = momentnum;
	}

	/** full constructor */
	public User(String username, String upassword, String phonenum, String userclass, String userimg, String selfintro,
			String userplace, String pageimg, Integer likenum, Integer fannum, Integer photonum, Integer videonum,
			Integer contactnum, Integer momentnum, Set moments, Set ilikesForLikerid, Set discussmakes, Set comzans,
			Set ilikesForLikedid) {
		this.username = username;
		this.upassword = upassword;
		this.phonenum = phonenum;
		this.userclass = userclass;
		this.userimg = userimg;
		this.selfintro = selfintro;
		this.userplace = userplace;
		this.pageimg = pageimg;
		this.likenum = likenum;
		this.fannum = fannum;
		this.photonum = photonum;
		this.videonum = videonum;
		this.contactnum = contactnum;
		this.momentnum = momentnum;
		this.moments = moments;
		this.ilikesForLikerid = ilikesForLikerid;
		this.discussmakes = discussmakes;
		this.comzans = comzans;
		this.ilikesForLikedid = ilikesForLikedid;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUpassword() {
		return this.upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getUserclass() {
		return this.userclass;
	}

	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}

	public String getUserimg() {
		return this.userimg;
	}

	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}

	public String getSelfintro() {
		return this.selfintro;
	}

	public void setSelfintro(String selfintro) {
		this.selfintro = selfintro;
	}

	public String getUserplace() {
		return this.userplace;
	}

	public void setUserplace(String userplace) {
		this.userplace = userplace;
	}

	public String getPageimg() {
		return this.pageimg;
	}

	public void setPageimg(String pageimg) {
		this.pageimg = pageimg;
	}

	public Integer getLikenum() {
		return this.likenum;
	}

	public void setLikenum(Integer likenum) {
		this.likenum = likenum;
	}

	public Integer getFannum() {
		return this.fannum;
	}

	public void setFannum(Integer fannum) {
		this.fannum = fannum;
	}

	public Integer getPhotonum() {
		return this.photonum;
	}

	public void setPhotonum(Integer photonum) {
		this.photonum = photonum;
	}

	public Integer getVideonum() {
		return this.videonum;
	}

	public void setVideonum(Integer videonum) {
		this.videonum = videonum;
	}

	public Integer getContactnum() {
		return this.contactnum;
	}

	public void setContactnum(Integer contactnum) {
		this.contactnum = contactnum;
	}

	public Integer getMomentnum() {
		return this.momentnum;
	}

	public void setMomentnum(Integer momentnum) {
		this.momentnum = momentnum;
	}

	public Set getMoments() {
		return this.moments;
	}

	public void setMoments(Set moments) {
		this.moments = moments;
	}

	public Set getIlikesForLikerid() {
		return this.ilikesForLikerid;
	}

	public void setIlikesForLikerid(Set ilikesForLikerid) {
		this.ilikesForLikerid = ilikesForLikerid;
	}

	public Set getDiscussmakes() {
		return this.discussmakes;
	}

	public void setDiscussmakes(Set discussmakes) {
		this.discussmakes = discussmakes;
	}

	public Set getComzans() {
		return this.comzans;
	}

	public void setComzans(Set comzans) {
		this.comzans = comzans;
	}

	public Set getIlikesForLikedid() {
		return this.ilikesForLikedid;
	}

	public void setIlikesForLikedid(Set ilikesForLikedid) {
		this.ilikesForLikedid = ilikesForLikedid;
	}

}