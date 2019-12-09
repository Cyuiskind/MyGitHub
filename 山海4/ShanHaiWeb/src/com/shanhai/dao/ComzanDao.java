package com.shanhai.dao;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shanhai.model.Comzan;

@Service @Transactional
public class ComzanDao {
	@Resource SessionFactory factory;
	
	//增
	public void AddComzan(Comzan comzan) throws Exception{
		Session s = factory.getCurrentSession();
		s.save(comzan);
	}
	
	
	//删
	public void DeleteComzan(Integer czid) throws Exception{
		Session s = factory.getCurrentSession();
		Object Comzan = s.load(Comzan.class, czid);
		s.delete(Comzan);
	}
	
	//改
	public void UpdateComzan(Comzan comzan) throws Exception{
		Session s = factory.getCurrentSession();
		s.update(comzan);
	}
	
	//查
	@SuppressWarnings("unchecked")
	public ArrayList<Comzan> QueryAllComzan(){
		Session s = factory.getCurrentSession();
		String hql = "From Comzan";
		Query q = s.createQuery(hql);
		List ComzanList = q.list();
		return (ArrayList<Comzan>) ComzanList; 
	}
	
	public Comzan GetComzanById(Integer czId) {
		Session s = factory.getCurrentSession();
		Comzan comzan = (Comzan)s.get(Comzan.class, czId);
		return comzan;
	}
	
	public ArrayList<Comzan> QueryComzanInfo(String comtext){
		Session s = factory.getCurrentSession();
		String hql = "From Comzan comzan where 1=1";
		if(!comtext.equals("")) 
			hql = hql + " and comzan.comtext like '%" + comtext + "%";
		Query q = s.createQuery(hql);
		List ComzanList = q.list();
		return (ArrayList<Comzan>) ComzanList; 
	}

}
