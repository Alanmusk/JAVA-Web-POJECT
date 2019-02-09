package com.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BaseData;
import com.entity.User;

public class UpdataUserServlet extends HttpServlet {

	/**
	 * 序列化
	 */

	private static final long serialVersionUID = 1L;

	/* 设置表单提交方式 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 根据用户ID跳转到用户信息修改页面显示 */
		// 获取ID参数
		String idStr = request.getParameter("id");
		if (idStr != null && !idStr.equals("")) {
			// Integer.valueOf方法可以返回一个表示指定的 int 值的 Integer 实例。
			Integer id = Integer.valueOf(idStr);
			// 创建用户数据操作对象,为提高对象作用域在此处创建。
			BaseData data = new BaseData();
			// 调用根据用户ID方法，查询用户信息
			List<User> list = data.selectUserById(new User(id));
			request.setAttribute("list", list);
		}
		request.getRequestDispatcher("pages/updata.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 修改用户信息 */
		// 获取修改页面的用户信息
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String id = request.getParameter("id");
		System.out.println(username);
		System.out.println(userpwd);
		System.out.println(id);
		// 创建用户操作对象
		User user = new User();
		// 为用户字符集的信息设置中文乱码处理，并把用户信息存储到用户对象中。
		user.setUsername(new String(username.getBytes("ISO-8859-1"), "UTF-8"));
		user.setUserpwd(new String(userpwd.getBytes("ISO-8859-1"), "UTF-8"));
		user.setId(Integer.valueOf(id));
		// 创建用户数据操作对象,为提高对象作用域在此处创建。
		BaseData data = new BaseData();
		// 调用修改用户方法，修改用户信息
		data.updateUser(user);
		// 跳发跳转到显示servlet
		request.getRequestDispatcher("ShowUserServlet").forward(request, response);
	}
}
