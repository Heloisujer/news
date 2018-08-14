<%@page import="com.klcm.news.pojo.User"%>
<%@ page import="java.util.List"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + 
			":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<meta charset="UTF-8">
		<title>用户信息</title>
    <base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/userlist.css"/>
		<script src="js/jquery-2.1.1.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<h1 class="user-title">用户信息</h1>
		<table class="list">
			<th colspan="6">
				<form action="users/findByLike" method="post">
					<input type="text" placeholder="按用户名搜索" name="uName" id="search-input" class="search-input" />
					<input type="submit"class="search-submit" value="搜索"/>
				</form>
			</th>
			<tr class="tr_title">
				<td>UID</td>
				<td>用户名</td>
				<td class="pswd">密码</td>
				<td>姓名</td>
				<td>联系方式</td>
				<td>Email</td>
				<td>职位</td>
				<td>操作</td>
			</tr>
		<c:forEach  items="${users}" var="user">
		<tr class="value-tr">
			<td class="value-td">${user.id}</td>
			<td class="value-td">${user.uName}</td>
			<td class="value-td pswd">${user.uPwd}</td>
			<td class="value-td">${user.name}</td>
			<td class="value-td">${user.phone}</td>
			<td class="value-td">${user.email}</td>
			<td class="value-td">${user.job}</td>
			<td class="value-botton">
				<button type="button" class="btn update">修改</button>
				<button type="button" class="btn delete">删除</button>
			</td>
		<tr>
		</c:forEach>
		</table>
		
		<button class="add" id="add">添加</button>
		<div class="box">
			<button class="close" id="close">关闭</button>
			<form id="form">
			
			<div class="box-th">
				<p id="id-p">ID</p>
			    <input type="text" id="id" name="id" class="id" />
			</div>
			<div class="box-th">
				<p>用户名</p>
				<input type="text" id="uName" name="uName" class="uName" />
			</div>
			<div class="box-th">
				<p>密码</p>
				<input type="text" id="uPwd" name="uPwd" class="uPwd" />
			</div>
			<div class="box-th">
				<p>姓名</p>
				<input type="text" id="name" name="name" class="name" />
			</div>
			<div class="box-th">
				<p>联系方式</p>
				<input type="text" id="phone" name="phone" class="phone" />
			</div>
			<div class="box-th">
				<p>Email</p>
				<input type="text" id="email" name="email" class="email" />
			</div>
			<div class="box-th">
				<p>职位</p>
				<input type="text" id="job" name="job" class="job" />
			</div>
				<input type="submit" value="提交" class="submit"/>
			</form>
			
		</div>
		<div class="shaw"></div>
	</body>
	<script type="text/javascript">
		$(function(){
			$("#add").click(function(){
			if ($(".box").css("display")=="none") {
				$(".box").css({
					"display":"block"
				})
//				$(".box").css("display","block")
				$(".submit").attr({
					"value":"添加"
				})
//				$("#id").val();
			}
		  })
		})
		
		
		
		$("#close").click(function() {
		$(".box").css({
			"display" : "none"
		});

		$(".box-shadow").css({
			"display" : "none"
		});

		/* 清空残留数据 */
		$("#id").val("");
		$("#uName").val("");
		$("#upwd").val("");
		$("#name").val("");
		$("#phone").val("");
		$("#email").val("");
		$("#job").val("");
		$(".submit").removeClass("add_submit").removeClass("update_submit");
	});

	/*添加按钮*/
	$("#add").click(function() {
		if ($(".box").css("display") == "none") {
			/*先让添加框显示*/
			$(".box").css({
				"display" : "block"
			});
			$(".submit").attr({
				"value" : "添加"
			});

			$(".submit").addClass("add_submit");

			$(".box-shadow").css({
				"display" : "block"
			});
			$("#form").submit(function(){	
				$.ajax({
					type : 'post',
					url:"${pageContext.request.contextPath}/users/addUser",
					data:$('#form').serialize(),
					dataType:'json',
					async:false,
					success : function(data){
						alert(data.msg);
					}  
					/* error : function(data){
						alert(data.msg);
					} */
					
				});
			});
			//添加
			 /* $(".add_submit").off().on("click",".add_submit",function(){
				alert("添加");
				$.ajax({
					type:"post",
					url:"${pageContext.request.contextPath}/users/addUser",
					data:$('#form').serialize(),
					dataType:'json',
					async:true,
					success:function(data){
						alert(data.msg);
		
					}
			});
		}) */ 
		
		
		}

	})

	//点击修改按钮
	$(".update").click(function() {
		
		//获取值
         var id = $(this).parents("tr").find("td").eq(0).html();
         var uName = $(this).parents("tr").find("td").eq(1).html();
         var uPwd = $(this).parents("tr").find("td").eq(2).html();
         var name = $(this).parents("tr").find("td").eq(3).html();
         var phone = $(this).parents("tr").find("td").eq(4).html();
         var email = $(this).parents("tr").find("td").eq(5).html();
         var job = $(this).parents("tr").find("td").eq(6).html();
         
		if ($(".box").css("display") == 'none') {

			$(".box").css({
				"display" : "block"
			});

			$(".submit").attr({
				"value" : "修改"
			});

			$(".submit").addClass("update_submit");

			/* 阴影 */
			$(".box-shadow").css({
				"display" : "block"
			});

			//先给前端修改页面显示：修改数据
			$("#id").val(id);
			$("#uName").val(uName);
			$("#uPwd").val(uPwd);
			$("#name").val(name);
			$("#phone").val(phone);
			$("#email").val(email);
			$("#job").val(job);
			$("#form").submit(function(){
				
				$.ajax({
					type : 'post',
					url:"users/updateUser",
					data:$('#form').serialize(),
					dataType:'json',
					async:false,
					success : function(data){
						alert(data.msg);
					}
				});
			});
			//修改
			/* $(".add_form").off().on("click",".add_submit",function(){
//   	        evt.preventDefault();
				alert("提交表单");
     	         $.ajax({
     	        	type:"post",
     		        url:"${pageContext.request.contextPath}/users/updateUser",
     		        data:$("#form").serialize(),
     		        dataType:"json",
     		        success:function(data){
     			        alert(data.msg);
     		        }
     	      });
           }) */
		}
	})

	//删除
	$(".delete").click(function(){
			var uId = $(this).parents("tr").find("td").eq(0).html();
			var _that = $(this);
			$.ajax({
				type:"post",
				url:"users/deleteUser?uId="+uId,
				dataType:'json',
				async:false,
				success:function(data){
      			    alert(data.msg);      			         			
					_that.parents("tr").remove(); 
      		    }
			});
		})
		
		
	</script>
</html>
