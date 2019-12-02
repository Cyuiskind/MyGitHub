package com.shanhai.dao;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shanhai.model.Discussmake;

@Service @Transactional
public class DiscussmakeDao {
	@Resource SessionFactory factory;
	
	//增
	public void AddDiscussmake(Discussmake discussmake) throws Exception{
		Session s = factory.getCurrentSession();
		s.save(discussmake);
	}
	
	
	//删
	public void DeleteDisscussmake(Integer disId) throws Exception{
		Session s = factory.getCurrentSession();
		Object disscussmake = s.load(Discussmake.class, disId);
		s.delete(disscussmake);
	}
	
	//改
	public void UpdateUser(Discussmake discussmake) throws Exception{
		Session s = factory.getCurrentSession();
		s.update(discussmake);
	}
	
	//查
	public ArrayList<Discussmake> QueryAllDiscussmake(){
		Session s = factory.getCurrentSession();
		String hql = "From Discussmake";
		Query q = s.createQuery(hql);
		List DiscussmakeList = q.list();
		return (ArrayList<Discussmake>) DiscussmakeList; 
	}
	
	public Discussmake GetDiscussmakeById(Integer disId) {
		Session s = factory.getCurrentSession();
		Discussmake discussmake = (Discussmake)s.get(Discussmake.class, disId);
		return discussmake;
	}
	
	public ArrayList<Discussmake> QueryDiscussmakeInfo(String discontent){
		Session s = factory.getCurrentSession();
		String hql = "From Discussmake discussmake where 1=1";
		if(!discontent.equals("")) 
			hql = hql + " and discussmake.discontent like '%" + discontent + "%";
		Query q = s.createQuery(hql);
		List DiscussmakeList = q.list();
		return (ArrayList<Discussmake>) DiscussmakeList; 
	}

}
