package com.gsy.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertThread implements Runnable{
	Connection conn;
	PreparedStatement pStatement;
	String[] str ;
	public InsertThread(Connection conn,String[] str) {
		this.conn = conn;
		this.str = str;
	}
	String sql = "insert into table_stu(id,name) values(3,\"wangqian\")";
	@Override
	public void run() {
		try {
			for(int i = 0;i<str.length;i++) {
				System.out.println(sql+"|"+conn);
				pStatement =(PreparedStatement) conn.prepareStatement(sql);
				pStatement.executeUpdate();
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
