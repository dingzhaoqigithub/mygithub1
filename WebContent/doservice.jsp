<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="st" class="com.bean.Student" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="st"></jsp:setProperty>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<%
String op=request.getParameter("op");
%>
<jsp:forward page="stu.do">
<jsp:param value="<%=op %>" name="op"/>
</jsp:forward>
</head>
<body>

</body>
</html>