<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${pb==null}">
<c:redirect url="stu.do?op=5"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<script type="text/javascript">
   //更改每页记录数的函数
   function  doRows(){
	   var rows=document.form1.rows.value;
	   if(isNaN(rows)){
		   alert("请输入正确数字");
		   document.form1.rows.value=${pb.rows};
		   return;
	   }
	   window.location="stu.do?op=5&rows="+rows;
   }
 //更改跳转页的函数
   function  doPage(){
	   var page=document.form1.page.value;
	   if(isNaN(page)){
		   alert("请输入正确数字");
		   document.form1.page.value=${pb.page};
		   return;
	   }
	   window.location="stu.do?op=5&page="+page;
   }
</script>
</head>
<body>
<table width="600px" border="1" align="center">
  <tr align="center" bgcolor="#FFFFCC">
    <td colspan="7">学生信息展示</td>
  </tr>
  <tr>
    <td>编号</td>
    <td>姓名</td>
    <td>性别</td>
    <td>住址</td>
    <td>生日</td>
    <td>班级</td>
    <td>操作</td>
  </tr>
  <c:forEach items="${pb.pagelist}" var="st">
  <tr>
    <td>${st.stuid}</td>
    <td>${st.getSname()}</td>
    <td>${st.getSex()}</td>
    <td>${st.getAddress()}</td>
    <td>${st.getBirthday()}</td>
    <td>${st.getCname()}</td>
    <td>
    <a href="stu.do?op=3&sid=${st.stuid}">删除</a>
    <a href="stu.do?op=4&sid=${st.stuid}">修改</a>
    </td>
  </tr>
 </c:forEach>
  </table>
  <form action="" id="form1" name="form1" method="post">
  <table width="600px" border="1" align="center">
  <tr>
  <td>
    <c:if test="${pb.page>1}">
    <a href="stu.do?op=5&page=1">
   </c:if> 
      首页</a>
    </td>
  <td>
    <c:if test="${pb.page>1}">
    <a href="stu.do?op=5&page=${pb.page-1}">
   </c:if> 
      上一页</a>
  </td>
  <td>
   <c:if test="${pb.page<pb.maxpage}">
    <a href="stu.do?op=5&page=${pb.page+1}">
   </c:if> 
      下一页</a>
      </td>
  <td>
   <c:if test="${pb.page<pb.maxpage}">
    <a href="stu.do?op=5&page=${pb.maxpage}">
   </c:if> 
     尾页</a>
     </td>
  <td>每页
   <input type="text" size="2" name="rows" id="rows" value="${pb.rows}">
      条记录
   <input type="button" name="button" id="button" value="确定" onclick="doRows()"/>   
      </td>
  <td>跳
      <input type="text" size="2" name="page" id="page" value="${pb.page}">  
       转页
       <input type="button" name="button" id="button" value="确定" onclick="doPage()"/>   
       </td>
  <td>${pb.page}/${pb.maxpage}页</td>
  </tr>
  </table>
  </form>
  <p align="center">
<a href="stuadd.jsp">返回添加</a>
</p>
</body>
</html>