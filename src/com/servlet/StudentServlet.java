package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Clazz;
import com.bean.PageBean;
import com.bean.Student;
import com.biz.IStudentBiz;
import com.biz.StudentBiz;

public class StudentServlet extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(req, resp);
}
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
	   HttpSession session=request.getSession();
	    //���Ʋ���biz����
	   IStudentBiz ibiz=new StudentBiz();
	   //��ȡ�ͻ��˴��ݵ�������op
	   int op=Integer.parseInt(request.getParameter("op"));
	   switch (op) {
	           case 1://����
	        	   Student st=(Student)request.getAttribute("st");
	        	   boolean flag=ibiz.save(st);
	        	   System.out.println(request.getContextPath());
	        	   if(flag){
	        		   response.sendRedirect(request.getContextPath()+"/stu.do?op=5");
	        	   }else{
	        		   response.sendRedirect(request.getContextPath()+"error.jsp");
	        	   }
		
		       break;
	           case 2:
	        	    st=(Student)request.getAttribute("st");
	        	    flag=ibiz.update(st);
		        	   if(flag){
		        		   response.sendRedirect(request.getContextPath()+"/stu.do?op=5");
		        	   }else{
		        		   response.sendRedirect(request.getContextPath()+"error.jsp");
		        	   }
			       break;
	           case 3://ɾ��
	       		   String sid=request.getParameter("sid");
	       		   flag=ibiz.delById(Integer.parseInt(sid));
	       		if(flag){
	        		   response.sendRedirect(request.getContextPath()+"/stu.do?op=5");
	        	   }else{
	        		   response.sendRedirect(request.getContextPath()+"error.jsp");
	        	   }
			       break;
	           case 4:
	        	    sid=request.getParameter("sid");
	        	    Student oldst=ibiz.findById(Integer.parseInt(sid));
	        	    session.setAttribute("oldst", oldst);
	        	    response.sendRedirect(request.getContextPath()+"/stuupdate.jsp");
			       break;
	           case 5://��ѯ����
	       		 /*  List<Student> lsst=ibiz.findAll();
	       		   session.setAttribute("lsst", lsst);
	       		   List<Clazz> lsca=ibiz.doinit();
	       		   session.setAttribute("lsca", lsca);
	       		   response.sendRedirect(request.getContextPath()+"/stulist.jsp");*/
	        	   List<Clazz> lsca=ibiz.doinit();
	       		   session.setAttribute("lsca", lsca);
	        	   /**************��ҳ********************/
	        	    //��session�л�ȡpagebean��ҳ����
	        	   PageBean pb=(PageBean)session.getAttribute("pb");
	        	   pb=pb==null?new PageBean():pb;
	        	   String page=request.getParameter("page");
	        	   String rows=request.getParameter("rows");
	        	   //�����һ��ֱ�ӷ���List.jsp,���ܳ���page �� rows û��
	        	   page=page==null?""+pb.getPage():page;
	        	   rows=rows==null?""+pb.getRows():rows;
	        	   //��Stringתint
	        	   int ipage=Integer.parseInt(page);
	        	   int irows=Integer.parseInt(rows);
	        	   //����ÿҳ��¼���͵�ǰҳ
	        	   if(ipage<1)ipage=1;
	        	   if(irows<1)irows=5;
	        	   //��ȡ��ҳ��
	        	   int maxpage=ibiz.findmaxPage(irows);
	        	   if(ipage>maxpage)ipage=maxpage;
	        	   //��ȡ��ǰҳ���ݼ���
	        	   List<Student> lsst=ibiz.findPageAll(ipage, irows);
	        	   //����ҳ���ݷ�װ��pb
	        	   pb.setPage(ipage);
	        	   pb.setRows(irows);
	        	   pb.setMaxpage(maxpage);
	        	   pb.setPagelist(lsst);
	        	   session.setAttribute("pb", pb);
	        	   response.sendRedirect(request.getContextPath()+"/stulist.jsp");
	        	   /**************��ҳend********************/
			       break;
	           case 6://�༶��ʼ��
	        	    lsca=ibiz.doinit();
	       		   session.setAttribute("lsca", lsca);
	       		   response.sendRedirect(request.getContextPath()+"/stuadd.jsp");
			       break;
	         

	default:
		break;
	}
	   
	}
}
