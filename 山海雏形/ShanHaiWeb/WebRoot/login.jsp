<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
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

    <div  style="opacity:0.8">
        <div class="be-content pren">

            <div class="ioc_text">
                <img src="images/logo.png" style="height:100px;">
            </div>

            <div>
                <form action ="user/user_login" method ="post">
                    <div class="br-content">

                         <div class="input-group mb-4 bootint">
                             <div class="input-group-prepend">
                                 <span class="input-group-text"><i class="fa fa-user"></i></span>
                             </div>
                             <input type="text" class="form-control" name="user.username" placeholder="用户名">
                         </div>

                         <div class="input-group mb-4 bootint">
                             <div class="input-group-prepend">
                                 <span class="input-group-text"><i class="fa fa-unlock-alt"></i></span>
                             </div>
                             <input type="password" class="form-control" name="user.upassword" placeholder="密码">
                         </div>

                        <div class="br-text">
                            <p>
                                <span>忘记密码?</span>
                                <a href="">找回</a>
                            </p>
                        </div>
                        <div style="padding-top: 10px">
                            <input type="submit" class="btn" value="登录"><br>
                        </div>
                        <div style="padding-top: 10px">
                            <input type="button" class="btn" onclick="window.location.href='register.jsp'" value="注册">
                        </div>
                        <br>
                    </div>
                </form>
            </div>

        </div>
    </div>
	
</body>

</html>
