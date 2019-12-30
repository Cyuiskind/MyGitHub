package com.shanhai.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shanhai.model.Moment;

@Service @Transactional

public class MomentDao {
@Resource SessionFactory factory;
	
	//增
	public void AddMoment(Moment moment) throws Exception{
		Session s = factory.getCurrentSession();
		s.save(moment);
	}
	
	
	//删
	public void DeleteMoment(Integer MomentId) throws Exception{
		Session s = factory.getCurrentSession();
		Object Moment = s.load(Moment.class, MomentId);
		s.delete(Moment);
	}
	
	//改
	public void UpdateMoment(Moment moment) throws Exception{
		Session s = factory.getCurrentSession();
		s.update(moment);
	}
	
	//查
	public ArrayList<Moment> QueryAllMoment(){
		Session s = factory.getCurrentSession();
		String hql = "From Moment";
		Query q = s.createQuery(hql);
		List<Moment> MomentList = q.list();
		return (ArrayList<Moment>) MomentList; 
	}
	
	public Moment GetMomentById(Integer momentId) {
		Session s = factory.getCurrentSession();
		Moment moment = (Moment)s.get(Moment.class, momentId);
		return moment;
	}
	
	public ArrayList<Moment> QueryMomentInfo(String momentcontent){
		Session s = factory.getCurrentSession();
		String hql = "From Moment moment where 1=1";
		if(!momentcontent.equals("")) 
			hql = hql + " and (moment.comentcontent like '%" + momentcontent + "%' or "+
		      "moment.title like '%" + momentcontent + "%')";
		Query q = s.createQuery(hql);
		List MomentList = q.list();
		
		return (ArrayList<Moment>) MomentList; 
	}
	
	public ArrayList<Moment> TheMoments(int userid){
		Session s = factory.getCurrentSession();
		String hql = "From Moment moment where 1=1";
		hql = hql + " and (moment.user.userid =" + userid + ")";
		Query q = s.createQuery(hql);
		List MomentList = q.list();
		return (ArrayList<Moment>) MomentList;
	}
}
