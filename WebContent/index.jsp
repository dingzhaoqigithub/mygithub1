<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<%
 //servlet是运行在服务器端的一段小程序，专门用来接收请求，相当于以前的doservice
%>
</head>
<body>
<form action="mytest.do" method="post">
<input type="submit" value="post方式访问servlet">
</form>
<a href="mytest.do">get方式访问servlet</a>
</body>
</html>