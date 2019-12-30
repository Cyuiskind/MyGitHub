package com.shanhai.model;

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
	private Integer likenum;
	private Integer fannum;
	private Integer photonum;
	private Integer videonum;
	private Integer contactnum;
	private Integer momentnum;
	private Set moments = new HashSet(0);
	private Set moments_1 = new HashSet(0);
	private Set ilikesForLikedid = new HashSet(0);
	private Set ilikesForLikerid = new HashSet(0);
	private Set discussmakes = new HashSet(0);
	private Set discussmakes_1 = new HashSet(0);
	private Set ilikesForLikerid_1 = new HashSet(0);
	private Set comzans = new HashSet(0);
	private Set ilikesForLikedid_1 = new HashSet(0);
	private Set comzans_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String upassword, String phonenum) {
		this.username = username;
		this.upassword = upassword;
		this.phonenum = phonenum;
	}

	/** full constructor */
	public User(String username, String upassword, String phonenum, String userclass, String userimg, String selfintro,
			String userplace, String pageimg, Integer likenum, Integer fannum, Integer photonum, Integer videonum,
			Integer contactnum, Integer momentnum, Set moments, Set moments_1, Set ilikesForLikedid,
			Set ilikesForLikerid, Set discussmakes, Set discussmakes_1, Set ilikesForLikerid_1, Set comzans,
			Set ilikesForLikedid_1, Set comzans_1) {
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
		this.moments_1 = moments_1;
		this.ilikesForLikedid = ilikesForLikedid;
		this.ilikesForLikerid = ilikesForLikerid;
		this.discussmakes = discussmakes;
		this.discussmakes_1 = discussmakes_1;
		this.ilikesForLikerid_1 = ilikesForLikerid_1;
		this.comzans = comzans;
		this.ilikesForLikedid_1 = ilikesForLikedid_1;
		this.comzans_1 = comzans_1;
	}

	public User(User u1) {
		this.username = u1.username;
		this.upassword = u1.upassword;
		this.phonenum = u1.phonenum;
		this.userclass = u1.userclass;
		this.userimg = u1.userimg;
		this.selfintro = u1.selfintro;
		this.userplace = u1.userplace;
		this.pageimg = u1.pageimg;
		this.likenum = u1.likenum;
		this.fannum = u1.fannum;
		this.photonum = u1.photonum;
		this.videonum = u1.videonum;
		this.contactnum = u1.contactnum;
		this.momentnum = u1.momentnum;
		this.moments = u1.moments;
		this.moments_1 = u1.moments_1;
		this.ilikesForLikedid = u1.ilikesForLikedid;
		this.ilikesForLikerid = u1.ilikesForLikerid;
		this.discussmakes = u1.discussmakes;
		this.discussmakes_1 = u1.discussmakes_1;
		this.ilikesForLikerid_1 = u1.ilikesForLikerid_1;
		this.comzans = u1.comzans;
		this.ilikesForLikedid_1 = u1.ilikesForLikedid_1;
		this.comzans_1 = u1.comzans_1;
	}
	
	public void editfrom(User u1) {
//		this.username = u1.username;
		this.upassword = u1.upassword;
//		this.phonenum = u1.phonenum;
		this.userclass = u1.userclass;
//		this.userimg = u1.userimg;
//		this.selfintro = u1.selfintro;
//		this.userplace = u1.userplace;
//		this.pageimg = u1.pageimg;
		this.likenum = u1.likenum;
		this.fannum = u1.fannum;
		this.photonum = u1.photonum;
		this.videonum = u1.videonum;
		this.contactnum = u1.contactnum;
		this.momentnum = u1.momentnum;
		this.moments = u1.moments;
		this.moments_1 = u1.moments_1;
		this.ilikesForLikedid = u1.ilikesForLikedid;
		this.ilikesForLikerid = u1.ilikesForLikerid;
		this.discussmakes = u1.discussmakes;
		this.discussmakes_1 = u1.discussmakes_1;
		this.ilikesForLikerid_1 = u1.ilikesForLikerid_1;
		this.comzans = u1.comzans;
		this.ilikesForLikedid_1 = u1.ilikesForLikedid_1;
		this.comzans_1 = u1.comzans_1;
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

	public Set getMoments_1() {
		return this.moments_1;
	}

	public void setMoments_1(Set moments_1) {
		this.moments_1 = moments_1;
	}

	public Set getIlikesForLikedid() {
		return this.ilikesForLikedid;
	}

	public void setIlikesForLikedid(Set ilikesForLikedid) {
		this.ilikesForLikedid = ilikesForLikedid;
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

	public Set getDiscussmakes_1() {
		return this.discussmakes_1;
	}

	public void setDiscussmakes_1(Set discussmakes_1) {
		this.discussmakes_1 = discussmakes_1;
	}

	public Set getIlikesForLikerid_1() {
		return this.ilikesForLikerid_1;
	}

	public void setIlikesForLikerid_1(Set ilikesForLikerid_1) {
		this.ilikesForLikerid_1 = ilikesForLikerid_1;
	}

	public Set getComzans() {
		return this.comzans;
	}

	public void setComzans(Set comzans) {
		this.comzans = comzans;
	}

	public Set getIlikesForLikedid_1() {
		return this.ilikesForLikedid_1;
	}

	public void setIlikesForLikedid_1(Set ilikesForLikedid_1) {
		this.ilikesForLikedid_1 = ilikesForLikedid_1;
	}

	public Set getComzans_1() {
		return this.comzans_1;
	}

	public void setComzans_1(Set comzans_1) {
		this.comzans_1 = comzans_1;
	}

}