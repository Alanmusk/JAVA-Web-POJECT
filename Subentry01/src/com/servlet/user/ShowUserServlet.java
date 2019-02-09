package com.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BaseData;
import com.entity.User;

public class ShowUserServlet extends HttpServlet{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println(">>> user show");
		//创建用户数据操作对象
		BaseData data = new BaseData();
		//调用查询方法，获得查询信息
		List<User> list = data.selectAllUser();
		//把获得的查询信息放置到请求域中，再在页面获取
		request.setAttribute("list", list);
		//转发跳转到主页面
		request.getRequestDispatcher("pages/main.jsp").forward(request, response);
	}
}
