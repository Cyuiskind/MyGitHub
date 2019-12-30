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
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="<%=basePath%>images/logo.png">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	</head>
	<body>

    <div style="opacity:0.8">
        <div class="be-content pren">

            <div class="ioc_text">
                <img src="images/logo.png" style="height:100px;">
            </div>

            <div>
                <form action="user/user_addUser" method="post">
                    <div class="br-content">
                    <table>
                    <tr>  <td>用户名</td><td><input type="text" name="user.username" class="form-control"></td>
                    </tr>
                   <tr>  <td>手机号 </td><td><input type="text" name="user.phonenum" class="form-control"></td>
                    <tr>  <td>密码 </td><td><input type="password" name="user.upassword" class="form-control"></td>
 <!--                </tr>
                    <tr>  <td>确认密码</td><td><input type="password" class="form-control"></td>
                    </tr> --> 
                    <tr><td></td><td></td></tr>
                        </table>
                    </div>
                    <div style="padding-top: 10px" align="center">
                            <input type="submit" class="btn" style="width:100px" value="注册" >
                             <input type="button" class="btn" style="width:100px" onclick="window.location.href='login.jsp'" value="返回登录" >
                        </div>
                        <br>
                </form>
            </div>

        </div>
    </div>
	
</body>

</html>

