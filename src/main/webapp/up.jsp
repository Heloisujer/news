<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + 
			":" + request.getServerPort() + request.getContextPath() + "/";%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>新用户表上传</title>
    <form action="users/poi" method="post" enctype="multipart/form-data">
			<input type="file" name="file" id="file" reqiured="reqiured"/>
			<input type="submit" value="提交"/>
			</form>

  </head>
  
  <body>
  
  </body>
</html>

