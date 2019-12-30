<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>瞬间</title>
     
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="<%=basePath%>images/logo.png">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/add.css">
<style>
.title{
background-image:url("../images/titlebg.png");
width=100%;
height=100%;
}

</style>


  </head>
  
  <body>
<div align="right" class="title">
 
<table width="100%">
<tr>
<td width=33% align="right">
		<img src="<%=basePath%>images/logo.png" style="height: 200px;width: 200px">
</td>
<td width=33% align="center">
		<i class="font1">山海民风</i>
</td>
<td width=33% align="left">
</td>
</tr>
</table>

<table width=100%>
<tr>
<td width=33%>
	  <c:choose>
		       <c:when test="${user.username==null}">
		       </c:when>
		       <c:otherwise>
		          <a href="postmoment.jsp" ><font size="5"><b>发布瞬间</b></font></a>
		          <a href="" ><font size="5"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;关注：0</b></font></a>
		          <a href="" ><font size="5"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;粉丝：0</b></font></a>
		       </c:otherwise>
	 </c:choose>
</td>
<td width=33% align="right">
	 <s:form action="moment/moment_queryMoments" method="post" class="parent">	          
	        <input type="text" name="keyWords" class="search" placeholder="Search......">	
	 </s:form>
</td>
<td width=33% align="right">
	  <c:choose>
		       <c:when test="${user.username==null}">
		         <div><a href="login.jsp"><img src="images/login.png">登录</a>|
	     		 <a href="register.jsp"><img src="images/register.png">注册</a></div>
		       </c:when>
		       <c:otherwise>
		         <img src="<%=basePath%><s:property value='#session.user.userimg'/>" style="height: 60px; width:60px">
		         <a href="user/user_showone?user.userid=<s:property value='#session.user.userid'/>"><s:property value='#session.user.username'/></a>
				 <a href="user/user_logout" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注销</a>
		       </c:otherwise>
	 </c:choose>
</td>
</tr>
</table>
</div>




<br>
     <s:iterator value="momentList">
 <table>
 <tr>
 <td><img src="<%=basePath%><s:property value='user.userimg'/>" style="height: 50px;width:50px"></td>
 <td><a href="user/user_showone?user.userid=<s:property value='user.userid'/>"><b><h3><s:property value='user.username'/></h3></b></a></td>
 </tr>
 <tr>
 <td>&nbsp;</td>
 <td><table>
 <tr><td><a href = "moment/moment_showDetail?moment.momentid=<s:property value='momentid'/>"><h4><s:property value='title'/></h4></a></td></tr>
 <tr>
 <td>
 <s:property value='comentcontent'/><br>
 </td>
 </tr>
 <tr>
 <td><img src="<%=basePath%><s:property value='momentimg1'/>" style="height: 200px;width:300px"></td>
 </tr>
 <tr><td>
 <a href="moment/moment_dianzan?moment.momentid=<s:property value='momentid'/>" >赞</a>
  				<s:property value='likenum'/>&nbsp;&nbsp;&nbsp;
  				<a href="moment/moment_share?moment.momentid=<s:property value='momentid'/>" >转发</a>
  				<s:property value='sharenum'/>&nbsp;&nbsp;&nbsp;
  				<a href="moment/moment_pinglun?moment.momentid=<s:property value='momentid'/>" >评论</a>
  				<s:property value='commentnum'/><hr>
 </td>
 </tr>
 </table></td>
 </tr>
 </table>
 <hr class="hcs"><br>
 </s:iterator>
  </body>
<ml>