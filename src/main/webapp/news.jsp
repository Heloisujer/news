<%@page import="com.klcm.news.pojo.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + 
			":" + request.getServerPort() + request.getContextPath() + "/";
	pageContext.setAttribute("APP_PATH", request.getContextPath());			
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
 <meta charset="UTF-8">
		<title>新闻信息</title>
    <base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/newslist.css"/>
		<script src="js/jquery-2.1.1.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<h1 class="news-title">新闻信息</h1>
		<table class="list">
			<th colspan="6">
				<form action="newss/findByLike" method="post">
					<input type="text"  placeholder="按新闻标题搜索" name="title" id="search-input" class="search-input" />
					<input type="submit"class="search-submit" value="搜索"/>
				</form>
			</th>
			<tr class="tr_title">
				<td>NID</td>
				<td>新闻标题</td>
				<td>作者</td>
				<td>内容</td>				
				<td>发布时间</td>
				<td>种类</td>
				<td>图片</td>
				<td>操作</td>
			</tr>
		<c:forEach  items="${newss}" var="news">
		<tr class="value-tr">
			<td class="value-td">${news.id}</td>
			<td class="value-td">${news.title}</td>
			<td class="value-td">${news.author}</td>
			<td class="value-td">${news.cont}</td>	
			<td class="value-td">${news.pubtime}</td>
			<td class="value-td">${news.kind.type}</td>	
			<td class="value-td"><img class="yu" src="${news.address}"/></td> 
			<td class="value-botton">
				<button type="button" class="btn update">修改</button>
				<button type="button" class="btn delete">删除</button>
			</td>
		<tr>
		</c:forEach>
		</table>
		
		<button type="button"  class="add" id="add">添加</button>
		<div class="box">
			<form  method="post" class="form" id="form" enctype="multipart/form-data">
			<button type="button"  class="close" id="close">关闭</button>
			<div class="box-th">
				<p id="id-p">NID</p>
			    <input type="text" id="id" name="id" class="id" required="required" />
			</div>
			<div class="box-th">
				<p>新闻标题</p>
				<input type="text" id="title" name="title" class="title" required="required"/>
			</div>
			<div class="box-th">
				<p>作者</p>
				<input type="text" id="author" name="author" class="author" required="required" />
			</div>
			<div class="box-th">
				<p>内容</p>
				<input type="text" id="cont" name="cont" class="cont" required="required" />
			</div>
			<div class="box-th">
				<p>图片</p>
				<input type="file" id="file" name="file" class="file"/>
			</div>
			<div class="box-th">
				<p>发布时间</p>
				<input type="text" id="pubtime" name="pubtime" class="pubtime" required="required" />
			</div>
			<div class="box-th">
				<p>种类</p>
				<input type="text" id="type" name="type" class="type" required="required"/>
			</div>
				<input type="button" value="提交" class="submit" required="required"/>
			</form>
			
		</div>
		<div class="shaw"></div>
	</body>
	<script type="text/javascript">
	function fun() {
		$(".box").css({
			"display" : "none"
		});

		$(".box-shadow").css({
			"display" : "none"
		});

		/* 清空残留数据 */
		/* 清空残留数据 */
		$("#id").val("");
		$("#title").val("");
		$("#author").val("");
		$("#cont").val("");
		$("#address").val("");
		$("#pubtime").val("");
		$("#type").val("");
		$(".submit").removeClass("add_submit").removeClass("update_submit");
	}

		//关闭窗口
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

				$(".submit").addClass("add_submit");

				$(".box-shadow").css({
					"display" : "block"
				});

		
		
	$(".submit").click(function(){
		var fd=new FormData(document.getElementById("form"));
		$.ajax({
			type:"post",
			url:"newss/addNews",
  		    data:fd,
	        dataType:'json',
  		    enctype:"multipart/form-data",
  		    contentType:false,
  		    processData:false,
  		    success:function(data){
  			    alert(data.msg);
  			    fun();
  			    location.reload();
  		    }
		});
	});
			}
		})
		
		
		
		
		/*更新按钮*/
	$(".update").click(function() {
		//获取对应的值 填入 表格中
		//获取值
         var id = $(this).parents("tr").find("td").eq(0).html();
         var title = $(this).parents("tr").find("td").eq(1).html();
         var author = $(this).parents("tr").find("td").eq(2).html();
         var cont = $(this).parents("tr").find("td").eq(3).html();
         var pubtime = $(this).parents("tr").find("td").eq(4).html();
         var type = $(this).parents("tr").find("td").eq(5).html();
         var address = $(this).parents("tr").find("td").eq(6).html();
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
			$("#title").val(title);
			$("#author").val(author);
			$("#cont").val(cont);
			$("#pubtime").val(pubtime);
			$("#type").val(type);
			$("#address").val(address);
			
		//更新
			$(".submit").click(function(){
				var fd=new FormData(document.getElementById("form"));
				$.ajax({
					type:"post",
					url:"newss/updateNews",
		  		    data:fd,
			        dataType:'json',
		  		    enctype:"multipart/form-data",
		  		    contentType:false,
		  		    processData:false,
		  		    success:function(data){
		  			    alert(data.msg);
		  			    fun();
		  			    location.reload();
		  		    }
				});
			});
					}
				})
	
	/*删除按钮*/
	$(".delete").click(function(){
			var nId = $(this).parents("tr").find("td").eq(0).html();
			var _that = $(this);
			$.ajax({
				type:"post",
				url:"newss/deleteNews?nId="+nId,
				//data:("#form").serialize(),
				dataType:'json',
				async:true,
				success:function(data){
      			    alert(data.msg);
      			  _that.parents("tr").remove(); 
      			    
      		    }
			});
		})

	
</script>
</html>
		
		
		
		
		
		
		
		

	
		
         


