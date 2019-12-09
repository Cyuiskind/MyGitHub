package com.shanhai.dao;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shanhai.model.Ilike;

@Service @Transactional
public class IlikeDao {
	@Resource SessionFactory factory;
	
	//增
	public void AddIlike(Ilike ilike) throws Exception{
		Session s = factory.getCurrentSession();
		s.save(ilike);
	}
	
	
	//删
	public void DeleteIlike(Integer likeid) throws Exception{
		Session s = factory.getCurrentSession();
		Object ilike = s.load(Ilike.class, likeid);
		s.delete(ilike);
	}
	
	//改
	public void UpdateIlike(Ilike ilike) throws Exception{
		Session s = factory.getCurrentSession();
		s.update(ilike);
	}
	
	//查
	public ArrayList<Ilike> QueryAllIlike(){
		Session s = factory.getCurrentSession();
		String hql = "From Ilike";
		Query q = s.createQuery(hql);
		List ilikeList = q.list();
		return (ArrayList<Ilike>) ilikeList; 
	}
	
	public Ilike GetUserById(Integer IlikeId) {
		Session s = factory.getCurrentSession();
		Ilike ilike = (Ilike)s.get(Ilike.class, IlikeId);
		return ilike;
	}
	
	public ArrayList<Ilike> QueryUserInfo(Integer liker){ //我的关注
		Session s = factory.getCurrentSession();
		String hql = "From Ilike ilike where 1=1";
		if(!(liker==null)) 
			hql = hql + " and likerid =" + liker ;
		Query q = s.createQuery(hql);
		List LikerList = q.list();
		return (ArrayList<Ilike>) LikerList; 
	}

}
