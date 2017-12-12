package com.gsy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JDBCConnect {
	public static void main(String[] args) {
		System.out.println("测试idea   git提交");
		String[] arr = new String[1];
		List<a> list = new ArrayList<a>();
		for (int i = 0; i < 4; i++) {
			list.add(new a(i + "", i + ""));
		}
		System.out.println("==============");
		Long time1 = new Date().getTime();
		addTypes(list);
		System.out.println(new Date().getTime() - time1);
		// Long time1 = new Date().getTime();
		// for(int i = 0;i<4;i++) {
		// arr[i]=String.valueOf(i);
		// }
		// arr[0]="1";
		// for(int i = 0;i<50;i++) {
		// connectJDBC(1);
		// connectJDBC(1);
		// connectJDBC(1);
		// connectJDBC(1);
		// }
		// System.out.println(new Date().getTime()-time1);
		//
		// Connection conn = getCon(null);
		// if (conn != null) {
		// System.out.println("连接成功");
		// //多线程插入
		// Long time = new Date().getTime();
		// for(int i = 0;i<50;i++) {
		// Thread t1 = new Thread(new InsertThread(conn,arr));
		// t1.run();
		// }
		//
		//
		// Thread t1 = new Thread(new InsertThread(conn,arr));
		// Thread t2 = new Thread(new InsertThread(conn,arr));
		// Thread t3 = new Thread(new InsertThread(conn,arr));
		// Thread t4 = new Thread(new InsertThread(conn,arr));
		// t1.run();
		// t2.run();
		// t3.run();
		// t1.run();
		// System.out.println(new Date().getTime()-time);
		// }
		// closeJDBC(conn);
	}

	public static int addTypes(List<a> babyList) {
		String sql = "insert into table_stu (id,name) values (?,?) ";
		Connection conn = getCon(null);
	    try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}          
		int result = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			for (int i = 1; i < babyList.size(); i++) {
				if (i == 2) {
					stmt.setString(1, "1");
					stmt.setString(2, "2");
					stmt.addBatch();
					continue;
				}
				stmt.setString(1, babyList.get(i).getId());
				stmt.setString(2, babyList.get(i).getName());
				stmt.addBatch();
				stmt.executeBatch();
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			closeJDBC(conn);
		}
		return result;
	}

	// 获取连接
	public static Connection getCon(Connection con) {
		if (con == null) {
			String url = "jdbc:mysql://127.0.0.1:3306/own_test";
			String username = "root";
			String password = "123456";
			try {
				con = DriverManager.getConnection(url, username, password);
				con.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		} else {
			return con;
		}
	}

	// 关闭连接
	public static void closeJDBC(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void connectJDBC(int pid) {
		Connection con = null;
		// Statement statement = null;
		PreparedStatement pStatement = null;
		ResultSet result = null;
		String url = "jdbc:mysql://127.0.0.1:3306/own_test";
		String username = "root";
		String password = "123456";
		String sql = "insert into table_stu(id,name) values(3,\"wangqian\")";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false);
			// if(type==1){
			pStatement = (PreparedStatement) con.prepareStatement(sql);
			// pStatement.setInt(1, pid);
			pStatement.executeUpdate();
			con.commit();
			pStatement.close();
			con.close();
			// }else{
			// statement = (Statement) con.createStatement();
			// sql = sql.replace("?", " ");
			// result = statement.executeQuery(sql+pid);
			// }

			// while (result.next()) {
			// int id = result.getInt(1);
			// String name = result.getString(2);
			// System.out.println(id + "||" + name);
			// }
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class a {
	String id;
	String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public a(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}