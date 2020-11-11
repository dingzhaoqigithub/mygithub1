package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnAction {
   private static Connection conn;
  public static Connection getconn(){
			try {
				//1.数据库驱动加载
				Class.forName("com.mysql.jdbc.Driver");
				//2.使用驱动管理器，获取数据库连接对象
			 conn=DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/db?characterEncoding=utf-8",
						"root",
						"java"
						);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
			
  }
  public static void CloseAll(ResultSet rst,PreparedStatement ps,Statement st,Connection conn){
		try {
			if(rst!=null)rst.close();
			if(ps!=null)ps.close();
			if(st!=null)st.close();
			if(conn!=null)conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
  }
  
}
