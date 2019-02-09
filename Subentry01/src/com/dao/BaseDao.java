package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc基础操作
 * 
 * @author Administrator
 *
 */
public class BaseDao {

	// 驱动类
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	// 连接方式
	private final static String URL = "jdbc:mysql://localhost:3306/subentry01?characterEncoding=utf-8";
	// 账号
	private final static String USER = "root";
	// 密码
	private final static String PASSWORD = "111111";

	/* jdbc操作对象 */

	/**
	 * 数据库连接对象
	 */
	protected static Connection conn;
	/**
	 * 数据库执行对象
	 */
	protected PreparedStatement ps;
	/**
	 * 结果集对象
	 */
	protected ResultSet rs;
	/**
	 * 影响行数
	 */
	protected int count = -1;

	/**
	 * 获得连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭资源
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (null != ps) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (null != rs) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询操作
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeQuery(String sql, Object... params) {
		getConnection();// 调用连接对象的方法
		try {
			ps = conn.prepareStatement(sql);
			// 为占位符赋值
			if (null != params) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			// 获得查询结果集
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 增删改操作
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executUpdate(String sql, Object... params) {
		getConnection();// 调用连接对象的方法
		try {
			ps = conn.prepareStatement(sql);
			// 为占位符赋值
			if (null != params) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			// 获得增删改操作影响行数
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		return count;
	}

	/**
	 * 数据库连接测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("此处为数据库连接提示：");
		System.err.println(getConnection());
	}

}
