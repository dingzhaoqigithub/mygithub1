package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Clazz;
import com.bean.Student;

public class StudentDao implements IStudentDao{
    private ResultSet rst=null;
	@Override
	public List<Clazz> doinit() {
		String sql="select * from clazz";
		//1.获取数据库中数据的结果集
		rst=DbHelperDao.executeQuery(sql, null);
		//2.从结果集取出数据封装到要返回的集合里面
		   //2.1先声明集合
		List<Clazz> lsca=new ArrayList<Clazz>();
		  //2.2遍历rst结果集
		  try {
			while(rst.next()){
			Clazz  ca=new Clazz(
					rst.getInt(1)+"",
					rst.getString(2)
					);
			lsca.add(ca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lsca;
	}
	@Override
	public boolean save(Student st) {
		String sql="insert into student(sname,sex,address,birthday,classid) values(?,?,?,?,?)";
		int rows=DbHelperDao.executeUpdate(sql, new Object[]{
				st.getSname(),
				st.getSex(),
				st.getAddress(),
				st.getBirthday(),
				st.getClassid()
		});
		if(rows>0){
			return true;
		}
		return false;
	}
	@Override
	public List<Student> findAll() {
		List<Student> lsst=new ArrayList<Student>();
		String sql="select * from vwstu";
		rst=DbHelperDao.executeQuery(sql, null);
		try {
			while(rst.next()){
			Student st=new Student(
					rst.getInt(1)+"",
					rst.getString(2),
					rst.getString(3),
					rst.getString(4),
					rst.getString(5),
					rst.getInt(6)+"",
					rst.getString(7)
					);	
			lsst.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lsst;
	}
	@Override
	public boolean delById(int sid) {
		String sql="delete from student where stuid=?";
		int rows=DbHelperDao.executeUpdate(sql, new Object[]{sid});
		if(rows>0){
			return true;
		}
		return false;
	}
	@Override
	public Student findById(int sid) {
		String sql="select * from vwstu where stuid=?";
		rst=DbHelperDao.executeQuery(sql, new Object[]{sid});
		try {
		if(rst.next()){
			Student st=new Student(
					rst.getInt(1)+"",
					rst.getString(2),
					rst.getString(3),
					rst.getString(4),
					rst.getString(5),
					rst.getInt(6)+"",
					rst.getString(7)
					);	
			return st;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean update(Student st) {
		String sql="update student set sname=?,sex=?,address=?,birthday=?,classid=? where stuid=?";
		int rows=DbHelperDao.executeUpdate(sql, new Object[]{
				st.getSname(),
				st.getSex(),
				st.getAddress(),
				st.getBirthday(),
				st.getClassid(),
				st.getStuid()
		});
		if(rows>0){
			return true;
		}
		return false;
	}
	@Override
	public List<Student> findPageAll(int page, int rows) {
		List<Student> lsst=new ArrayList<Student>();
		String sql="select * from vwstu order by stuid limit "+(page-1)*rows+","+rows;
		System.out.println("sql===>"+sql);
		rst=DbHelperDao.executeQuery(sql, null);
		try {
			while(rst.next()){
			Student st=new Student(
					rst.getInt(1)+"",
					rst.getString(2),
					rst.getString(3),
					rst.getString(4),
					rst.getString(5),
					rst.getInt(6)+"",
					rst.getString(7)
					);	
			lsst.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lsst;
	}
	@Override
	public int findmaxPage(int rows) {
		int maxrows=0;//总记录数
		int maxpage=0;//总页数
		String sql="select count(*) from vwstu";
		rst=DbHelperDao.executeQuery(sql, null);
		try {
			while(rst.next()){
			maxrows=rst.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(maxrows==0){
			maxpage=1;
		}else{
			maxpage=maxrows%rows==0?maxrows/rows:maxrows/rows+1;
		}
		return maxpage;
	}
}
