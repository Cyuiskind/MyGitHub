<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="images/孔雀花.jpg">
	  <h1 align="center">用户注册界面</h1>
	  <hr>
	  <div align="center">
	  	<s:form action="user/user_addUser" method="post">
		  	<s:textfield name="user.username" label="用户名"></s:textfield>
		  	<s:password name="user.upassword" label="密码"></s:password>
		  	<s:textfield name="user.phonenum" label="手机号"></s:textfield>
		  	<s:submit value="注册"></s:submit>
	  	</s:form>
	  </div>
  </body>
</html>
