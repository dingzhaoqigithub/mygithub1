package com.biz;

import java.util.List;

import com.bean.Clazz;
import com.bean.Student;

public interface IStudentBiz {
	    //新增学生对象到学生表
		public boolean save(Student st);
		//查询所有学生信息到页面
		public List<Student> findAll();
		//删除学生对象映射到学生表
		public boolean delById(int sid);
		//查询学生表中指定学生信息
		public Student findById(int sid);
		//修改学生表中指定学生信息
		public boolean update(Student st);
	    //查询班级表的所有信息，
		public List<Clazz> doinit();
		//分页查询获取结果集合
		public List<Student> findPageAll(int page,int rows);
		//获取总页数
		public int findmaxPage(int rows);
}
