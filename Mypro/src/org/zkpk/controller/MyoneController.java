package org.zkpk.controller;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zkpk.dao.HdataDao;

@Controller
@RequestMapping(value="/myone")
public class MyoneController {
	
	@RequestMapping(value="/peryear.do")
	@ResponseBody
	public JSONObject getYear(){
		return HdataDao.getPerYear();
	}
	
	@RequestMapping(value="/countryall.do")
	@ResponseBody
	public JSONObject getCountryAll(){
		return HdataDao.getCountryAll();
	}
	
	@RequestMapping(value="/yearhurt.do")
	@ResponseBody
	public JSONObject getYearHurt(){
		return HdataDao.getYearhurt();
	}
	
	@RequestMapping(value="/countryhurt.do")
	@ResponseBody
	public JSONObject getCountryHurt(){
		return HdataDao.getCountryhurt();
	}
	
	@RequestMapping(value="/weap.do")
	@ResponseBody
	public JSONObject getWeap(){
		return HdataDao.getWeap();
	}
	
	@RequestMapping(value="/viccountry.do")
	@ResponseBody
	public JSONObject getVicCountry(){
		return HdataDao.getVicCountry();
	}
	
	@RequestMapping(value="/victype.do")
	@ResponseBody
	public JSONObject getVicType(){
		return HdataDao.getVicType();
	}
	
	@RequestMapping(value="/succ.do")
	@ResponseBody
	public JSONObject getSucc(){
		return HdataDao.getSucc();
	}
	
	@RequestMapping(value="/suice.do")
	@ResponseBody
	public JSONObject getSuic(){
		return HdataDao.getSuice();
	}
	
	@RequestMapping(value="/extend.do")
	@ResponseBody
	public JSONObject getExtend(){
		return HdataDao.getExtend();
	}
	
	@RequestMapping(value="/certain.do")
	@ResponseBody
	public JSONObject getCertain(){
		return HdataDao.getCertain();
	}
	
	@RequestMapping(value="/citytime.do")
	@ResponseBody
	public JSONObject getCityAll(){
		return HdataDao.getCityAll();
	}
	
	@RequestMapping(value="/cityhurt.do")
	@ResponseBody
	public JSONObject getCityHurt(){
		return HdataDao.getCityhurt();
	}
	
	@RequestMapping(value="/home.do",method=RequestMethod.POST)
	@ResponseBody
	public List<JSONObject> getHome(){
		return HdataDao.getHome();
	
	}
	

}
