package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;

/**
 * 数据操作
 * 
 * @author Administrator
 *
 */
public class BaseData extends BaseDao {

	/**
	 * 用户查询所有
	 * 
	 * @return
	 */
	public List<User> selectAllUser() {
		// sql语句
		String sql = "select * from `user`";
		Object[] params = {};
		// 创建集合
		List<User> list = null;
		// 执行sql语句
		rs = this.executeQuery(sql, params);
		// 对查询的结果集进行为空判断
		if (rs != null) {
			// 创建集合，方便数据存储。
			list = new ArrayList<User>();
			try {
				// 把查询的结果，循环为user对象赋值，
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setUserpwd(rs.getString("userpwd"));
					// 把对象里的数据存储到集合中
					list.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// 关闭资源
			} finally {
				this.closeAll(conn, ps, rs);
			}
		}
		return list;
	}

	/**
	 * 用户根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public List<User> selectUserById(User user) {
		String sql = "SELECT * FROM `user` WHERE id = ?";
		Object[] params = { user.getId() };
		// 创建集合
		List<User> list = null;
		// 执行sql语句
		rs = this.executeQuery(sql, params);
		// 对查询的结果集进行为空判断
		if (rs != null) {
			// 创建集合，方便数据存储。
			list = new ArrayList<User>();
			try {
				// 把查询的结果，循环为user对象赋值，
				while (rs.next()) {
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setUserpwd(rs.getString("userpwd"));
					// 把对象里的数据存储到集合中
					list.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// 关闭资源
			} finally {
				this.closeAll(conn, ps, rs);
			}
		}
		return list;

	}

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(User user) {
		// sql语句
		String sql = "INSERT INTO `user`(id,username,userpwd)VALUES(?,?,?)";
		Object[] params = { user.getId(), user.getUsername(), user.getUserpwd() };
		// 执行sql语句
		try {
			count = this.executUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//对影响行数进行判断，反馈影响实际情况
		if (count != -1) {
			return true;
		}
		return false;
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user) {
		// sql语句
		String sql = "UPDATE `user` SET username = ?,userpwd = ? WHERE id = ?";
		Object[] params = { user.getUsername(), user.getUserpwd(), user.getId() };
		// 执行sql语句
		try {
			count = this.executUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//对影响行数进行判断，反馈影响实际情况
		if (count != -1) {
			return true;
		}
		return false;
	}

	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public boolean deleteUser(User user) {
		// sql语句
		String sql = "DELETE FROM `user` WHERE id=?";
		Object[] params = { user.getId()};
		// 执行sql语句
		try {
			count = this.executUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//对影响行数进行判断，反馈影响实际情况
		if (count != -1) {
			return true;
		}

		return false;
	}

}
