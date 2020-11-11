package com.biz;

import java.util.List;

import com.bean.Clazz;
import com.bean.Student;
import com.dao.IStudentDao;
import com.dao.StudentDao;

public class StudentBiz implements IStudentBiz {
    //¹ØÁªbizºÍdao
	IStudentDao sdao=new StudentDao();
	@Override
	public List<Clazz> doinit() {
		// TODO Auto-generated method stub
		return sdao.doinit();
	}
	@Override
	public boolean save(Student st) {
		// TODO Auto-generated method stub
		return sdao.save(st);
	}
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return sdao.findAll();
	}
	@Override
	public boolean delById(int sid) {
		// TODO Auto-generated method stub
		return sdao.delById(sid);
	}
	@Override
	public Student findById(int sid) {
		// TODO Auto-generated method stub
		return sdao.findById(sid);
	}
	@Override
	public boolean update(Student st) {
		// TODO Auto-generated method stub
		return sdao.update(st);
	}
	@Override
	public List<Student> findPageAll(int page, int rows) {
		// TODO Auto-generated method stub
		return sdao.findPageAll(page, rows);
	}
	@Override
	public int findmaxPage(int rows) {
		// TODO Auto-generated method stub
		return sdao.findmaxPage(rows);
	}

}
