<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + 
			":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <meta charset="utf-8" />
        <title>恐龙新闻登录</title>
    <base href="<%=basePath%>">
        <link rel="stylesheet" href="css/login.css" />
        <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/fun.base.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
	</head>
	<body>
		<div class="login">
			<h3>恐龙新闻</h3>
			<form action="users/login" name="form" id="form" method="post">
		    <div class="input_outer">
			    <span class="u_user"></span>
			    <input name="uName" class="text" placeholder="输入ID或用户名" type="text">
		    </div>
		    <div class="input_outer">
			    <span class="p_pwd"></span>
			    <label class="l-login login_password"></label>
			    <input id="pas" type="password" name="uPwd" class="text" placeholder="输入密码" onFocus="$('.login_password').hide()" onBlur="if(this.value=='') $('.login_password').show()">
		    </div>
		    <input class="submit" name="submit" type="submit" onclick="document.getElementById('form').submit()" value="登录" />	
	        </form>
	        <div class="sas">
				<a href="register.jsp">注册账号</a>
			</div>	
	        <font color="red">${msg1.msg}</font>
		</div>
	</body>
</html>
