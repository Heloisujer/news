<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + 
			":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>恐龙新闻官网</title>
        <meta charset="utf-8" />
    <base href="<%=basePath%>">
		<meta name="description" content="">
		<meta name="keywords" content="">
		<link href="css/reset.css" rel="stylesheet">
		<link href="css/index.css" rel="stylesheet">
		<link href="css/iconfont.css" rel="stylesheet">
		<script src="js/jquery-1.9.1.min.js"></script>
		<script src="js/common.js"></script>
		<script src="js/index.js"></script>
	</head>
<body>
<div class="nav">
    <div class="wrapper clearfix">
        <h1 class="fl"><a href="index.jsp"></a></h1>
        <ul class="navMid fl">
            <li class="down nav1"><a href="index.jsp">主页</a></li>
            <li class="down nav2"><a href="index.jsp">个人信息</a>
            	<ul>
                	<li><button class="btn" id="userInfo"><span>用户信息</span></button></li>
                    <li><button class="btn" id="upadtePwd"><span>修改密码</span></button></li>
                </ul>
            </li>
            <li class="down nav3"><a href="index.jsp">新闻中心</a>
            	<ul>
            		<li><button class="btn" id="newsKind"><span>新闻分类</span></button></li>
                	<li><button class="btn" id="newsInfo"><span>新闻信息</span></button></li>
                </ul>
            </li>
        </ul>
        <div class="nav_right fr">
        	<div class="search fl clearfix">
            	<!--<form>
                	<input type="text" class="search_box fl" value="search">
                	<input type="submit" class="search_btn fr" value="搜索">
            	</form>-->
            	<div class="user_name">
			  		<h4 class="userName">用户:${msg1.user.name}</h4>
					<a href="login.jsp" class="back_login">退出登录</a>
				</div>
       	 	</div>
		</div>
    </div>
</div>
<div class="news-iframes">
		<iframe class="iframes" id="iframes" src="home.jsp"></iframe>
</div>
</body>
<script type="text/javascript">
	$("#userInfo").click(function() {
		var iframes = document.getElementById("iframes");
		iframes.src = "users/findAll";
	});
	$("#upadtePwd").click(function() {
		var iframes = document.getElementById("iframes");
		/* 点击访问 获取用户接口 ，成功跳转 成功页面显示 */
		iframes.src = "updatePwd.jsp";
	});
	$("#newsKind").click(function() {
		var iframes = document.getElementById("iframes");
		/* 点击访问 获取用户接口 ，成功跳转 成功页面显示 */
		iframes.src = "kinds/findAll";
	});
	$("#newsInfo").click(function() {
		var iframes = document.getElementById("iframes");
		/* 点击访问 获取用户接口 ，成功跳转 成功页面显示 */
		iframes.src = "newss/findAll";
	});


</script>

</html>

