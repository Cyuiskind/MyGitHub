package org.zkpk.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import org.zkpk.util.MysqlDataBase;

import net.sf.json.JSONObject;

import org.zkpk.model.HdataModel;;

public class HdataDao {
	public static String getGuangXiShengCount(){   //模板
		String yunnan=null;
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql="select count from sheng where sheng='广西'";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				yunnan = executeQuery.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yunnan;
	}
	
	public List<Integer> getToday() {     //模板
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		try {

			Connection connct = MysqlDataBase.getConnct();
			String sql = "select day from updata ORDER BY time DESC limit 1";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				arrayList.add( executeQuery.getInt(1));
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public JSONObject getControlGanSu() { //模板
		ArrayList<String> arrayList = new ArrayList<String>();
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select shengao,yuchuli,huidan,chongzhang,jishi,date from  service_data   where province='甘肃' ORDER BY date desc limit 1";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				arrayList.add(executeQuery.getString(1));
				arrayList.add(executeQuery.getString(2));
				arrayList.add(executeQuery.getString(3));
				arrayList.add(executeQuery.getString(4));
				arrayList.add(executeQuery.getString(5));
				String date = executeQuery.getString(6);
				json.put("data", arrayList);
				json.put("date", date);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	
	
	////////////////////////////////////////////
	public static JSONObject getPerYear() { //这几年发生袭击的次数对比
		ArrayList<Integer> year = new ArrayList<Integer>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select iyear,count(*) from `mypro`.`hdata` group by iyear order by iyear;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				year.add(Integer.parseInt(executeQuery.getString(1)));
				num.add(Integer.parseInt(executeQuery.getString(2)));
				json.put("year", year);
				json.put("num", num);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getCountryAll() { //此期间发生袭击最多的国家
		ArrayList<String> country = new ArrayList<String>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select country_txt,count(*) from `mypro`.`hdata` group by country_txt order by count(*) desc limit 10;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				country.add(executeQuery.getString(1));
				num.add(Integer.parseInt(executeQuery.getString(2)));
				json.put("country", country);
				json.put("num", num);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getYearhurt() { //每年因恐怖袭击造成的伤亡数
		ArrayList<Integer> year = new ArrayList<Integer>();
		ArrayList<Integer> dnum = new ArrayList<Integer>();
		ArrayList<Integer> wnum = new ArrayList<Integer>();
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select iyear,sum(nkill),sum(nwound) from `mypro`.`hdata` group by iyear order by iyear;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				year.add(Integer.parseInt(executeQuery.getString(1)));
				dnum.add(Integer.parseInt(executeQuery.getString(2)));
				wnum.add(Integer.parseInt(executeQuery.getString(3)));
				json.put("year", year);
				json.put("dnum", dnum);
				json.put("wnum", wnum);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getCountryhurt() { //因恐怖袭击伤亡数前十国家
		ArrayList<String> country = new ArrayList<String>();
		ArrayList<Integer> dnum = new ArrayList<Integer>();
		ArrayList<Integer> wnum = new ArrayList<Integer>();
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select country_txt,sum(nkill),sum(nwound) from `mypro`.`hdata` group by country_txt order by sum(nkill) desc limit 10;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				country.add(executeQuery.getString(1));
				dnum.add(Integer.parseInt(executeQuery.getString(2)));
				wnum.add(Integer.parseInt(executeQuery.getString(3)));
				json.put("country", country);
				json.put("dnum", dnum);
				json.put("wnum", wnum);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getWeap() { //使用的前五武器   饼图
		ArrayList<String> weap = new ArrayList<String>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select weaptype1_txt,count(*) from `mypro`.`hdata` group by weaptype1_txt order by count(*) desc limit 5;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			int i=0;
			int sum = 0;
			while (executeQuery.next()&&i<4) {
				weap.add(executeQuery.getString(1));
				num.add(Integer.parseInt(executeQuery.getString(2)));
				json.put("name"+String.valueOf(i),executeQuery.getString(1) );
				System.out.println("name"+String.valueOf(i));
				json.put("value"+String.valueOf(i), Integer.parseInt(executeQuery.getString(2)));
				sum=sum+Integer.parseInt(executeQuery.getString(2));
				i++;
			}
			json.put("name4", "Other");
			json.put("value4", 160628-sum);
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getVicCountry() { //受害者国籍最多前十
		ArrayList<String> country = new ArrayList<String>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select natlty1_txt,count(*) from `mypro`.`hdata` group by natlty1_txt order by count(*) desc limit 10;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				country.add(executeQuery.getString(1));
				num.add(Integer.parseInt(executeQuery.getString(2)));
				json.put("country", country);
				json.put("num", num);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getVicType() { //受害者国籍最多前十
		ArrayList<String> type = new ArrayList<String>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select targtype1_txt,count(*) from `mypro`.`hdata` group by targtype1_txt order by count(*) desc limit 10;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				type.add(executeQuery.getString(1));
				num.add(Integer.parseInt(executeQuery.getString(2)));
				json.put("type", type);
				json.put("num", num);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getSucc() { //袭击成功失败
		int succ = 0;
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select count(*) from `mypro`.`hdata` where success=1;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				succ = Integer.parseInt(executeQuery.getString(1));
				json.put("succ", succ);
				json.put("fail", 160628-succ);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getSuice() { //袭击成功失败
		int suic = 0;
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select count(*) from `mypro`.`hdata` where suicide=1;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				suic = Integer.parseInt(executeQuery.getString(1));
				json.put("suic", suic);
				json.put("no", 160628-suic);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getExtend() { //袭击成功失败
		int ext = 0;
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select count(*) from `mypro`.`hdata` where extendedi=1;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				ext = Integer.parseInt(executeQuery.getString(1));
				json.put("extend", ext);
				json.put("no", 160628-ext);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getCertain() { //袭击成功失败
		int cer = 0;
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select count(*) from `mypro`.`hdata` where guncertain1=1;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				cer = Integer.parseInt(executeQuery.getString(1));
				json.put("certain", cer);
				json.put("no", 160628-cer);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getCityAll() { //此期间发生袭击最多的城市
		ArrayList<String> city = new ArrayList<String>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select city,count(*) from `mypro`.`hdata` group by city order by count(*) desc limit 10;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				city.add(executeQuery.getString(1));
				num.add(Integer.parseInt(executeQuery.getString(2)));
				json.put("city", city);
				json.put("num", num);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static JSONObject getCityhurt() { //因恐怖袭击伤亡数前十城市
		ArrayList<String> city = new ArrayList<String>();
		ArrayList<Integer> dnum = new ArrayList<Integer>();
		ArrayList<Integer> wnum = new ArrayList<Integer>();
		JSONObject json = new JSONObject();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select city,sum(nkill),sum(nwound) from `mypro`.`hdata` group by city order by sum(nkill)+sum(nwound) desc limit 10;";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				city.add(executeQuery.getString(1));
				dnum.add(Integer.parseInt(executeQuery.getString(2)));
				wnum.add(Integer.parseInt(executeQuery.getString(3)));
				json.put("city", city);
				json.put("dnum", dnum);
				json.put("wnum", wnum);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static List<JSONObject> getHome(){
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<String> list2 = new ArrayList<String>();
		
		int a=0;
		String b=null;
		
		
		Map<Integer, String> map=new HashMap<Integer, String>();
		try {
			Connection connenct = MysqlDataBase.getConnct();
			String sql = "select country_txt,count(*) from `mypro`.`hdata` group by country_txt order by count(*) desc;";
			Statement createStatement = connenct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				b = executeQuery.getString(1);
				a = Integer.parseInt(executeQuery.getString(2))/100;
				map.put(a, b);
			}
			MysqlDataBase.getClose(connenct, createStatement, executeQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Entry<Integer, String> entry : map.entrySet()) {
			
			list1.add(entry.getKey());
			list2.add(entry.getValue());
		}
		Object[] value= list1.toArray();		
		Object[] name=list2.toArray();
		List<JSONObject> list = new ArrayList<JSONObject>();
		for (int i = 0, j=0; i < list1.size()&&j<list2.size(); i++,j++) {
		    JSONObject json=new JSONObject();
			json.put("value", value[i]);
			json.put("name", name[j]);
			list.add(json);
		}
		return list;
	
	}


}
