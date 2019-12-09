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
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
   <a href="login.jsp">登录</a>
  <a href="register.jsp">注册</a>
    <s:form action="moment_queryMoments" method="post">
          <label>关键词：</label><input type="text" name="keyWords" placeholder="输入关键词"><s:submit value="搜索"></s:submit>
    	  <table>
    	   <c:forEach var="moment" items="${momentList}">
    	   <tr>
  				<td><a href = "moment/moment_showDetail?moment.momentid=${moment.momentid}"><c:out value="${moment.title}"></c:out></a></td>
  				<td><c:out value="${moment.comentcontent}"></c:out></td>
  				<td><a href="moment/moment_showEdit?moment.momentid=${moment.momentid}" >编辑</a></td>
  				<td><a href="moment/moment_deleteMoment?moment.momentid=${moment.momentid}" >删除</a></td>
  				<td><a href="moment/moment_dianzan?moment.momentid=${moment.momentid}" >点赞</a></td>
  				<td><a href="moment/moment_pinglun?moment.momentid=${moment.momentid}" >评论</a></td>
    		</c:forEach>
    	</table>
    </s:form>
  </body>
</html>
