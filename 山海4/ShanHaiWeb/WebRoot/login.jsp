<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body background="images/孔雀花.jpg">
  <h1 align="center">用户注册登录</h1>
  <hr>
  <div align="center">
  <!-- 因为在xml中设置url-pattern为*.action，所以必须设置action="login.action" -->
	  <form action ="user/user_login" method ="post">
	   	  <table cellspacing=5 border=0 bordercolor=#ffaa00>
		  <tr>
		  <th rowspan="3" background="images/background.jpg" style="width=90px"></th>
		  <td>用户名：</td><td><input class="message" name="user.username"></td></tr>
		  <tr><td>密码：</td><td><input class="message" type="password" name="user.upassword"></td></tr>
		  <tr><td colspan="2" align="center"><input type="submit" value="登录"> <input type="reset" value="重置"></td></tr>
		   <tr><td colspan="2" align="center"><input type="button" value="注册" onclick="window.location.href='register.jsp'"></td></tr>
		  </table>
  	  </form>
  </div>
  </body>
  </body>
</html>
