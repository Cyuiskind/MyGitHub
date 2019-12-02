package com.shanhai.model;

/**
 * Ilike entity. @author MyEclipse Persistence Tools
 */

public class Ilike implements java.io.Serializable {

	// Fields

	private Integer likeid;
	private User userByLikedid;
	private User userByLikerid;

	// Constructors

	/** default constructor */
	public Ilike() {
	}

	/** full constructor */
	public Ilike(User userByLikedid, User userByLikerid) {
		this.userByLikedid = userByLikedid;
		this.userByLikerid = userByLikerid;
	}

	// Property accessors

	public Integer getLikeid() {
		return this.likeid;
	}

	public void setLikeid(Integer likeid) {
		this.likeid = likeid;
	}

	public User getUserByLikedid() {
		return this.userByLikedid;
	}

	public void setUserByLikedid(User userByLikedid) {
		this.userByLikedid = userByLikedid;
	}

	public User getUserByLikerid() {
		return this.userByLikerid;
	}

	public void setUserByLikerid(User userByLikerid) {
		this.userByLikerid = userByLikerid;
	}

}