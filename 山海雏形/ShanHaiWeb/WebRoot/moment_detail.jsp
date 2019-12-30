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
    
    <title>My JSP 'moment_detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="<%=basePath%>images/logo.png">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <link rel="stylesheet" type="text/css" href="css/detail.css">
  <body>
    <h2 aligen="center"><c:out value="${moment.title}"></c:out></h2>
     <i>  发布人：<c:out value="${moment.user.username}"></c:out></i><br>
  <i> 发布时间：<c:out value="${moment.momentday}"></c:out>&nbsp;<c:out value="${moment.momenttime}"></c:out>&nbsp;&nbsp;</i><br>
 <i>   点赞数：<c:out value="${moment.likenum}"></c:out></i><br>
    <p><c:out value="${moment.comentcontent}"></c:out><p>
    <img alt="" src="<%=basePath%><c:out value="${moment.momentimg1}"></c:out>" height=400px width=600px><br>
 
    评论：<br>
    <div align="center">
	     <c:choose>
	       <c:when test="${moment.user.username== user.username}">
	         <a href="moment/moment_showEdit?moment.momentid=<c:out value="${moment.momentid}"></c:out>">修改瞬间内容</a><br>
	         <a href="moment/moment_deleteMoment?moment.momentid=<c:out value="${moment.momentid}"></c:out>">删除瞬间</a><br>
	       </c:when>
	       <c:when test="${'旦增'== user.username}">
	         <a href="moment/moment_showEdit?moment.momentid=<c:out value="${moment.momentid}"></c:out>">修改瞬间内容</a><br>
	         <a href="moment/moment_deleteMoment?moment.momentid=<c:out value="${moment.momentid}"></c:out>">删除瞬间</a><br>
	       </c:when>
	       <c:when test="${'Edgar'== user.username}">
	         <a href="moment/moment_showEdit?moment.momentid=<c:out value="${moment.momentid}"></c:out>">修改瞬间内容</a><br>
	         <a href="moment/moment_deleteMoment?moment.momentid=<c:out value="${moment.momentid}"></c:out>">删除瞬间</a><br>
	       </c:when>
	       <c:when test="${'李辅德'== user.username}">
	         <a href="moment/moment_showEdit?moment.momentid=<c:out value="${moment.momentid}"></c:out>">修改瞬间内容</a><br>
	         <a href="moment/moment_deleteMoment?moment.momentid=<c:out value="${moment.momentid}"></c:out>">删除瞬间</a><br>
	       </c:when>
	       <c:when test="${'格桑'== user.username}">
	         <a href="moment/moment_showEdit?moment.momentid=<c:out value="${moment.momentid}"></c:out>">修改瞬间内容</a><br>
	         <a href="moment/moment_deleteMoment?moment.momentid=<c:out value="${moment.momentid}"></c:out>">删除瞬间</a><br>
	       </c:when>
	       <c:otherwise>
	       </c:otherwise>
	     </c:choose>   
	     </div>
  </body>
<html>