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
    
    <title>修改瞬间</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="<%=basePath%>images/logo.png">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/macs.css">
	
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-fileupload.js"></script>

  </head>
  
   <style type="text/css">
    #preview{
        width: 360px;
        height:250px;
        border: 0;
        overflow: hidden;
    }
    #imghead{
        filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
    }
</style>
<script type="text/javascript">
    function previewImage(file) {
        var MAXWIDTH = 180;
        var MAXHEIGHT = 180;
        var div = document.getElementById('preview');
        if (file.files && file.files[0]) {
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.onload = function () {
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width = rect.width;
                img.height = rect.height;
                img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top + 'px';
            }
            var reader = new FileReader();
            reader.onload = function (evt) {
                img.src = evt.target.result;
            }
            reader.readAsDataURL(file.files[0]);
        }else{  //兼容IE
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
        }
    }

    function clacImgZoomParam( maxWidth, maxHeight, width, height ){
        var param = {top:0, left:0, width:width, height:height};
        if( width>maxWidth || height>maxHeight ){
            rateWidth = width / maxWidth;
            rateHeight = height / maxHeight;
            if( rateWidth > rateHeight ){
                param.width =  maxWidth;
                param.height = Math.round(height / rateWidth);
            }else{
                param.width = Math.round(width / rateHeight);
                param.height = maxHeight;
            }
        }
        param.left = Math.round((maxWidth - param.width) / 2);
        param.top = Math.round((maxHeight - param.height) / 2);
        return param;
    }
</script>
  
<body>
	 <h1 align="center"><font class="vintage" size="20">修改瞬间</font></h1>

	  <hr class="hcs">
	  <br>
	  
	 <div align="center">
	    <div class="row">
		   <div class="col-md-10">
		      <s:form action="moment/moment_editMoment" cssClass="form-horizontal" enctype="multipart/form-data">
		      <s:hidden name="moment.momentid"/> 
		       <div class="panel panel-success">
		           <div class="panel-body">
			                <label class="control-label col-md-3">标题</label>
			                <div class="col-md-4">
                              <input type="text" name="moment.title" value="${moment.title}" class="name">
                           </div>
			           </div> 
			           <br>			           
			           <div class="form-group">
			                <label class="control-label col-md-3">文字说明</label>
			                <div class="col-md-2">
                              <textarea rows="9" cols="40" name="moment.comentcontent">${moment.comentcontent}</textarea>
                            </div>
			           </div>
			  		  <div class="form-group">
                        <div class="fileupload fileupload-new" data-provides="fileupload">

                          <div>
					   <input type="file" name="mPhoto1" onchange="previewImage(this)"/>
                          </div>
                        </div>
			           </div>
                         <div id="preview">
						    <img id="imghead" border=0 src="<%=basePath%>${moment.momentimg1}" width="360" height="250" / alt="图片预览">
						</div>
			           </div> 	           
						<div align="center">
				          <input type="submit"  class="btn" style="color:black;" value="保存更改">
				         </div>
				   </div>
				</div>
		    </s:form>
		  </div>
	   </div>
	 </main>
	<script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
	<script src="<%=basePath%>js/bootstrap-fileupload.js"></script>
  </body>
</html>
