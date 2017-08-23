package com.gsy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class JDBCConnect {
	public static void main(String[] args) {
		connectJDBC(2,1);
	}

	public static void connectJDBC(int type,int pid){
		Connection con = null;
		//		Statement statement = null;
		PreparedStatement pStatement  = null;
		ResultSet result = null;
		String url = "jdbc:mysql://127.0.0.1:3306/own_test";
		String username = "root";
		String password = "";
		String sql = "select * from table_stu where id = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			//			if(type==1){
			pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, pid);
			result = pStatement.executeQuery();
			//			}else{
			//				statement = (Statement) con.createStatement();
			//				sql = sql.replace("?", " ");
			//				result = statement.executeQuery(sql+pid);
			//			}

			while(result.next()){
				int id = result.getInt(1);
				String name = result.getString(3);
				System.out.println(id+"||"+name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}




}
