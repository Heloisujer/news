<%@page import="com.klcm.news.pojo.Kind"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + 
			":" + request.getServerPort() + request.getContextPath() + "/";%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="UTF-8">
		<title></title>
		<title>新闻分类</title>   
		<link rel="stylesheet" type="text/css" href="css/userlist.css" />
        <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
	</head>
	<body>
	<h1 class="title">新闻分类</h1>
	<table class="list">
		<tr class="tr_title">
			<td>Id</td>
			<td>新闻分类目录</td>
			<td>操作</td>
		</tr>
		<c:forEach  items="${kinds}" var="kind">
		<tr class="value-tr">
			<td class="value-td">${kind.id}</td>
			<td class="value-td">${kind.type}</td>
			<td class="value-botton">
				<button type="button" class="btn update">修改</button>
				<button type="button" class="btn delete">删除</button>
			</td>
		<tr>
		</c:forEach>
			
		
	</table>
	<button class="add" id="add">添加</button>
	<div class="box">
		<form action="" class="add_form" method="post">
			<button type="button" id="close" class="close">关闭</button>
			<div class="box-th">
				<p id="id-p">ID</p>
				<input type="text" name="id" id="id" />
			</div>
			<div class="box-th">
				<p>新闻类别名</p>
				<input type="text" name="type" id="type" required="required" />
			</div>
			<input type="submit" class="submit" value="提交" />
		</form>
	</div>
	<div class="box-shadow"></div>
	</body>
	<script type="text/javascript">
     function fun(){
    	 $(".box").css({
 			"display" : "none"
 		});

 		$(".box-shadow").css({
 			"display" : "none"
 		});
 		/* 清空残留数据 */
 		$("#id").val("");
 		$("#type").val("");
 		$(".submit").removeClass("add_submit").removeClass("update_submit");
     }
	/*关闭按钮*/
	$("#close").click(function() {
		fun();
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

			$(".submit").addClass("add_submit");//.attr("class")

			$(".box-shadow").css({
				"display" : "block"
			});

			//提交事件
			$(".add_form").off().on("click",".add_submit",function(){
				$.ajax({
					type:"post",
					url:"kinds/addKind",
					data:$('.add_form').serialize(),
					dataType:'json',
					async:false,
					success:function(data){
						alert(data.msg);						
						fun();
						//window.location.reload();
						$(".list").append("<tr class='value-tr'><td class='value-td'>"+data.kind.id+"</td><td class='value-td'>"+data.kind.type+"</td><td class='value-botton'><button type='button' class='btn update'>修改</button><button type='button' class='btn delete'>删除</button></td></tr>");
						
					}
			});
		})
		}
	})

	$(document).on("click",".update",function(){
		/*获取我们对应的 id  type  */
		var id = $(this).parents("tr").find("td").eq(0).html();
		var type = $(this).parents("tr").find("td").eq(1).html();
		var _that = $(this);
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

			//先给前端修改页面显示：修改数据($().val())
			$("#id").val(id);
			$("#type").val(type);
		}
		//修改按钮
		$(".add_form").off().on("click",".submit",function(){
			//alert("ok");
			$.ajax({
				type:"post",
				url:"kinds/updateKind",
				data:$(".add_form").serialize(),
				dataType:'json',
				async:false,
				success:function(data){
					alert(data.msg);
					fun();
					_that.parents("tr").find("td").eq(1).html(data.kind.type);
					//window.location.reload();
				}
			});
		})
	})
	/*更新按钮*/
/* 	$(".update").click(function() {
		
	}) */
		/*删除按钮*/
	$(".list").on("click",".delete",function(){
			var kId = $(this).parents("tr").find("td").eq(0).html();	
			var _that = $(this);
			$.ajax({
				type:"post",
				url:"kinds/deleteKind?kId="+kId,
//	    		data:{
//    			"kId":kId;
//    		    },
			    dataType:'json',
			    async:true,
				success:function(data){
					alert(data.msg);
					fun();
					_that.parents("tr").remove();
					//_that.parents("tr").find("td").eq(1).html(data.kind.type);
					//window.location.reload();
				}
			});
		})
		</script>
</html>


