<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>恐怖袭击事件数据分析</title>
<script src="js/echarts.min.js"></script>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="static/css/bmap.css">
<style>
* {
	margin: 0;
	padding: 0;
	font-family: "Microsoft YaHei", '微软雅黑';
}

p {
	margin: 0 !important;
}

.f26 {
	font-weight: bold;
	font-size: 26px;
}

.f14 {
	font-size: 14px;
}


#wrapper {
	position: relative;
	margin: 0px auto;
	width: 100%;
	background-color: #353a48
}

#banner {
	position: relative;
	width: 100%;
	overflow: hidden;
}

.imgList {
	position: relative;
	width: 600%;
	z-index: 10;
	overflow: hidden;
}

.imgList .slider_div {
	float: left;
	display: inline-block;
	width: 16.66%;
}

#prev,#next {
	position: absolute;
	top: 50%;
	margin-top: -28px;
	z-index: 20;
	cursor: pointer;
	opacity: 0.8;
	filter: alpha(opacity =     80);
}

#prev {
	left: 10px;
}

#next {
	right: 10px;
}

#prev:hover,#next:hover {
	opacity: 0.8;
	filter: alpha(opacity =     80);
}

.indexList {
	position: absolute;
	right: 10px;
	top: 5px;
	z-index: 30;
}

.indexList li {
	float: left;
	margin-right: 5px;
	padding: 2px 4px;
	border: 2px solid black;
	background: grey;
	cursor: pointer;
}

.indexList .indexOn {
	background: red;
	font-weight: bold;
	color: white;
}
</style>


</head>
<body>
	<div id="wrapper">
		<!-- 最外层部分 -->
		<div id="banner">
			<!-- 轮播部分 -->
			<div class="imgList">
				<!-- 图片部分 -->
				
				
				<div class="slider_div">
					<div style="width: 100%;height: 100%;background-color: #580000">
						<p
							style="color: white;text-align: center;font-size: 28px; font-weight: bold;line-height: 46px;height: 46px;margin: 0;padding: 0;">恐怖袭击数据分析</p>
						<div style="height:100%;width:100%; background-color:#707070">
							<div class="container">
								<div class="row" style="margin-top:  30px">
									<div class="col-lg-12 text-center">
										<h3 class="section-subheading text-muted" style="color:black">袭击事件性质分析</h3>
									</div>
								</div>
								<div class="row" style="margin-top:  30px">
									<div class="col-md-6 col-sm-6 portfolio-item">
										<div id="six1" style="height:400px"></div>
									</div>
									<div class="col-md-6 col-sm-6 portfolio-item">
										<div id="six2" style="height:400px"></div>
									</div>
								</div>
								<button onclick="window.location.href='index.jsp'">第一页</button>
							</div>
						</div>
					</div>
				</div>
				
				
				
				<div class="slider_div">
					<div style="width: 100%;height: 100%;background-color: #580000">
						<p
							style="color: white;text-align: center;font-size: 28px; font-weight: bold;line-height: 46px;height: 46px;margin: 0;padding: 0;">恐怖袭击数据分析</p>
						<div style="height:100%;width:100%; background-color:#707070">
							<div class="container">
								<div class="row" style="margin-top:  30px">
									<div class="col-lg-12 text-center">
										<h3 class="section-subheading text-muted" style="color:black">袭击事件性质分析</h3>
									</div>
								</div>
								<div class="row" style="margin-top:  30px">
									<div class="col-md-6 col-sm-6 portfolio-item">
										<div id="seven1" style="height:400px"></div>
									</div>
									<div class="col-md-6 col-sm-6 portfolio-item">
										<div id="seven2" style="height:400px"></div>
									</div>
								</div>
								<button onclick="window.location.href='index.jsp'">第一页</button>
							</div>
						</div>
					</div>
				</div>
				
				
				
							
				
			</div>
		</div>
		<img src="./images/left.png" width="64" height="64" id="prev"> <img
			src="./images/right.png" width="64" height="64" id="next">

	</div>
	<input type="button"  onclick="window.location.href='two.jsp'" value="下一页">


	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="static/js/jquery-2.2.1.min.js"></script>
	<!-- 弹层插件 -->
	<script src="js/layer/layer.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="static/js/bootstrap.min.js"></script>
	<!-- echarts -->
	<script src="js/echarts.js"></script>

	<script type="text/javascript">
		require.config({
			paths : {
				'echarts' : 'js'
			}
		});

		var curIndex = 0, //当前index
		imgLen = $(".imgList .slider_div").length; //图片总数
		// 定时器自动变换2.5秒每次
		var autoChange = setInterval(function() {
			if (curIndex < imgLen - 1) {
				curIndex++;
			} else {
				curIndex = 0;
			}
			//调用变换处理函数
			/* changeTo(curIndex);  */
		}, 6000);
		//左箭头滑入滑出事件处理
		$("#prev").hover(function() {
			//滑入清除定时器
			clearInterval(autoChange);
		}, function() {
			//滑出则重置定时器
			//autoChangeAgain();
		});
		//左箭头点击处理
		$("#prev").click(function() {
			//根据curIndex进行上一个图片处理
			curIndex = (curIndex > 0) ? (--curIndex) : (imgLen - 1);
			changeTo(curIndex);
		});
		//右箭头滑入滑出事件处理
		$("#next").hover(function() {
			//滑入清除定时器
			clearInterval(autoChange);
		}, function() {
			//滑出则重置定时器
			/* autoChangeAgain(); */
		});
		//右箭头点击处理
		$("#next").click(function() {
			curIndex = (curIndex < imgLen - 1) ? (++curIndex) : 0;
			changeTo(curIndex);
		});
		//对右下角按钮index进行事件绑定处理等
		$(".indexList").find("li").each(function(item) {
			$(this).hover(function() {
				clearInterval(autoChange);
				changeTo(item);
				curIndex = item;
			}, function() {
				/* autoChangeAgain(); */
			});
		});
		//清除定时器时候的重置定时器--封装
		/*  function autoChangeAgain(){ 
		     autoChange = setInterval(function(){ 
		      if(curIndex < imgLen-1){ 
		        curIndex ++;
		      }else{ 
		        curIndex = 0;
		      }
		   	//调用变换处理函数
		     	changeTo(curIndex);
		     	},5000);
		 } */
		function changeTo(num) {
			var goLeft = num;
			$(".imgList").animate({
				left : "-" + goLeft * 100 + "%"
			}, 500);
			$(".indexList").find("li").removeClass("indexOn").eq(num).addClass(
					"indexOn");
		}
	</script>
	<script type="text/javascript"
		src="http://api.map.baidu.com/api?v=2.0&ak=whWrhHB8Q2orXafl4B9sb1fwuBsaqV8Q">
		//v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
		//v1.4版本及以前版本的引用方式：src="http://api.map.baidu.com/api?v=1.4&key=您的密钥&callback=initialize"
	</script>
	<script type="text/javascript" src="js/jslib/myone.js"></script>
	<script type="text/javascript" src="js/jslib/mytwo.js"></script>
	<script type="text/javascript" src="js/jslib/mythree.js"></script>
	<script type="text/javascript" src="js/jslib/myfour.js"></script>
	<script type="text/javascript" src="js/jslib/myfive.js"></script>
	<script type="text/javascript" src="js/jslib/mysix.js"></script>
	<script type="text/javascript" src="js/jslib/myseven.js"></script>
	<script type="text/javascript" src="js/echats.min.js"></script>
</body>
</html>
