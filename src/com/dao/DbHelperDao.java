package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DbConnAction;
import com.sun.org.apache.regexp.internal.recompile;

public class DbHelperDao {
   private static Connection conn;
   private static  PreparedStatement ps;
   private static ResultSet rst;
  /******通用的增删改******/
   public static int executeUpdate(String sql,Object[] obj){
	   //原始状态
	   conn=DbConnAction.getconn();
	   try {
		ps=conn.prepareStatement(sql);
		//判断obj是否有参数
		if(obj!=null&&obj.length>0){
			for(int i=0;i<obj.length;i++){
				ps.setObject(i+1, obj[i]);
			}
		}
		int rows=ps.executeUpdate();
		if(rows>0){
			return rows;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return -1;
	   
   }
  /******通用的查询******/
   public static ResultSet executeQuery(String sql,Object[] obj){
	   //原始状态
	   conn=DbConnAction.getconn();
	   try {
		ps=conn.prepareStatement(sql);
		//判断obj是否有参数
		if(obj!=null&&obj.length>0){
			for(int i=0;i<obj.length;i++){
				ps.setObject(i+1, obj[i]);
			}
		}
		rst=ps.executeQuery();
		return rst;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rst;
	   
   }
}
