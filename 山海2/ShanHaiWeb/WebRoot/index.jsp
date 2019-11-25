<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>山海民风初始界面</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body background="images/孔雀花.jpg">
  	<button type="button"  onclick="window.location.href='login.jsp'">登录</button>
  	<button type="button"  onclick="window.location.href='register.jsp'">注册</button>
  
  
  </body>
</html>
