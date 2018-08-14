<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + 
			":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<title>恐龙注册</title>
<link rel="stylesheet" href="css/register.css" />
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/fun.base.js"></script>
<script type="text/javascript" src="js/script.js"></script>
  </head>
  
  <body>
  <div class="logo_box">
	<h3>用户注册</h3>
	<form name="form" action="users/addUser" id="form" method="post">
		<div class="input_outer">
			<span class="u_user"></span>
			<input name="tName" class="text" placeholder="输入ID或用户名" style="color: #FFFFFF !important" type="text">
		</div>
		<div class="input_outer">
			<span class="us_uer"></span>
			<label class="l-login login_password" style="color: rgb(255, 255, 255);display: block;"></label>
			<input name="tPwd" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" onFocus="$('.login_password').hide()" onBlur="if(this.value=='') $('.login_password').show()" value="" placeholder="输入密码">
		</div>
		
		<div class="mb2"><a class="submit" name="submit" type="submit" onclick="document.getElementById('form').submit()" style="color: #FFFFFF">注册</a></div>
		
	</form>
	
</div>
 </body>
 
</html>
