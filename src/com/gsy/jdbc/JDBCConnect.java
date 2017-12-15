package com.gsy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mysql.jdbc.CallableStatement;

public class JDBCConnect {
	public static void main(String[] args) {
		Long time1 = new Date().getTime();
		connectJDBC(1);
		System.out.println(new Date().getTime() - time1);
		// String[] arr = new String[1];
		// List<A> list = new ArrayList<A>();
		// for (int i = 0; i < 4; i++) {
		// list.add(new A(i + "", i,""));
		// }
		// System.out.println("==============");
		// Long time1 = new Date().getTime();
		// addTypes(list);
		// System.out.println(new Date().getTime() - time1);
		// System.out.println("==============");
		// Connection conn = getCon(null);
		// if (conn != null) {
		// System.out.println("连接成功");
		// // 多线程插入
		// Long time = new Date().getTime();
		// for (int i = 0; i < 50; i++) {
		// Thread t1 = new Thread(new InsertThread(conn, arr));
		// t1.run();
		// }
		// Thread t1 = new Thread(new InsertThread(conn, arr));
		// Thread t2 = new Thread(new InsertThread(conn, arr));
		// Thread t3 = new Thread(new InsertThread(conn, arr));
		// Thread t4 = new Thread(new InsertThread(conn, arr));
		// t1.run();
		// t2.run();
		// t3.run();
		// t1.run();
		// System.out.println(new Date().getTime() - time);
		// }
		// closeJDBC(conn);
	}

	// 批量插入
	public static int addTypes(List<A> babyList) {
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
				stmt.setInt(2, babyList.get(i).getName());
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

	// 两种操作
	public static void connectJDBC(int pid) {
		Connection con = null;
		// Statement statement = null;
		PreparedStatement pStatement = null;
		ResultSet result = null;
		String url = "jdbc:mysql://127.0.0.1:3306/gsy_local";
		String username = "root";
		String password = "123456";
		String sql = "insert into table_stu (id,name) values (?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false);
			// if(type==1){
			for (int i = 0; i < 100; i++) {
//				pStatement = (PreparedStatement) con.prepareStatement(sql);
//				pStatement.setString(1, "2");
//				pStatement.setString(2, "2");
				CallableStatement cs = (CallableStatement) con.prepareCall("{call NewProc(2,2)}");
				int j = cs.executeUpdate();
//				pStatement.executeUpdate();
				con.commit();
			}

			// pStatement = (PreparedStatement) con.prepareStatement(sql);
			// pStatement.setInt(1, pid);
			// result = pStatement.executeQuery();
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

	{

	}

	class A {
		String id;
		int name;
		String type;

		public String getId() {
			return id;
		}

		public A() {
			super();
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getName() {
			return name;
		}

		public void setName(int name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public A(String id, int name, String type) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
		}
	}
}