<%@page import="com.klcm.news.pojo.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + 
			":" + request.getServerPort() + request.getContextPath() + "/";%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
		<meta charset="utf-8" />
		<title >修改密码</title>
		 <base href="<%=basePath%>">
	    <link rel="stylesheet" type="text/css" href="css/updatePwd.css"/>
	    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
	</head>
	<body>
	<h1 class="title">密&nbsp;码&nbsp;修&nbsp;改</h1>
	<div class="box">
		<form action="" id="form" method="post">
			<div class="box-th">
				<p>姓名:</p>
				<input type="text" name="uName" id="uName" placeholder="清输入你的用户名" value="${msg1.user.name}" required="required" readonly="readonly" />
			</div>
			<div class="box-th">
				<p>输入旧密码:</p>
				<input type="password" name="oPwd" id="oPwd" placeholder="请输入您原来的密码" required="required" /><span id="msg"></span>
			</div>
			<div class="box-th">
				<p>输入新密码:</p>
				<input type="password" name="nPwd" id="nPwd" placeholder="请输入您的新密码"  required="required"/> 
			</div>
			<div class="box-th">
				<p>确认新密码:</p>
				<input type="password" name="rePwd" id="rePwd" placeholder="请确认您的新密码" required="required" />
			</div>		
			<div class="value_button">
				<button type="button" class="update">确定</button>
				<button type="button" class="exit">取消</button>
			</div>
		</form>
	</div>
	</body>
	<script type="text/javascript">  	
	$(function() {
		var flag = 0;
		$("#oPwd").keyup(function() {
			var oPwd = $("#oPwd").val();
			$.ajax({
				type : "post",
				dataType : "json",
				data : {
					'oPwd' : oPwd
				},
				url : "users/checkPwd",
				async : true,
				success : function(data) {
					if (data.status == 0) {
						$("#msg").css("color", "red").html(data.msg);
					} else {
						flag = 1;
						$("#msg").css("color", "green").html(data.msg);
					}
				}
			});
		});

	
		$(".update").click(function() {
			if (flag == 1) {
				$.ajax({
					type : "post",
					dataType : "json",
					data : $("#form").serialize(),
					url : "users/updatePwd",
					async : true,
					success : function(data) {
						if (data.status == 1) {
							alert(data.msg);
							top.location.href = "login.jsp";
						} else {
							alert(data.msg);
							//window.location.reload();
						}
					}
				});
			}
		});
	});
	


    </script>
</html>

