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
    
    <title>山海民风</title>
     
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

</style>
  </head>
  
  <body>
  <img src="<%=basePath%><s:property value='user.pageimg'/>" style="height: 20%;width:100%">
  		 <table>
		 <tr>
		 <td><img src="<%=basePath%><s:property value='user.userimg'/>" style="height: 100px;width:100px"></td>
		 <td><h2><s:property value='user.username'/></h2></td>
		 <td><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称号：<s:property value='user.userclass'/></h3></td>
		 <td><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个性签名：<s:property value='user.selfintro'/></h3></td>
		 <td><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;住址：<s:property value='user.userplace'/></h3></td>
		 
  <c:choose>
	       <c:when test="${sessionScope.user.username == user.username}">
	       <td></td>
	            <td><a href="user/user_showeditself?user.userid=<s:property value='user.userid'/>"><h3>&nbsp;&nbsp;&nbsp;&nbsp;修改个人信息</h3></a></td>
	       </c:when>
	       <c:otherwise>
	       		<td><a href="user/user_like?user.userid=<s:property value='user.userid'/>"><h3>&nbsp;&nbsp;&nbsp;&nbsp;关注</h3></a></td>
	       </c:otherwise>
 </c:choose>
		
		 </tr>
<!--    <tr>
		 <td>&nbsp;</td>
		 <td><table>
		 <tr><td><a href = "moment/moment_showDetail?moment.momentid=<s:property value='momentid'/>"><h4><s:property value='title'/></h4></a></td></tr>
		 <tr>
		 <td>
		 <s:property value='comentcontent'/><br>
		 <td>
		 </tr> -->
		 </table>
<br>

    <s:form action="moment/moment_queryMoments" method="post">
          <div id="box">

        <input type="text" name="keyWords" class="sou" placeholder="请输入关键字">

        <input type="submit" value="搜索" style="width:50px;height:30px;border:none"> 
        <br>

    </div>


     </s:form>
     <br>
     <s:iterator value="momentList">
		 <table>
		 <tr>
		 <td><img src="<%=basePath%><s:property value='user.userimg'/>" style="height: 50px;width:50px"></td>
		 <td><b><a href="user/user_showone?user.userid=<s:property value='user.userid'/>"><s:property value='user.username'/></a></b></td>
		 </tr>
		 <tr>
		 <td>&nbsp;</td>
		 <td><table>
		 <tr><td><a href = "moment/moment_showDetail?moment.momentid=<s:property value='momentid'/>"><h4><s:property value='title'/></h4></a></td></tr>
		 <tr>
		 <td>
		 <s:property value='comentcontent'/><br>
		 <td>
		 </tr>
		 <tr>
		 <td><img src="<%=basePath%><s:property value='momentimg1'/>" style="height: 200px;width:300px"></td>
		 </tr>
		 <tr><td>
		 <a href="moment/moment_dianzan?moment.momentid=<s:property value='momentid'/>" >赞</a>
		  				<s:property value='likenum'/>&nbsp;&nbsp;&nbsp;
		  				<a href="moment/moment_dianzan?moment.momentid=<s:property value='momentid'/>" >转发</a>
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
</html>