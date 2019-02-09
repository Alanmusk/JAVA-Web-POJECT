package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BaseData;
import com.entity.User;

public class DeleteUserServlet extends HttpServlet {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/*设置表单提交方式*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println(">>> user delete");
		/* 获取ID参数 */
		String idStr = request.getParameter("id");
		//对获取的ID进行为空判断
		if(idStr != null && ! idStr.equals("")) {
			//Integer.valueOf方法可以返回一个表示指定的 int 值的 Integer 实例。
			Integer id = Integer.valueOf(idStr);
			//创建用户数据操作对象
			BaseData data = new BaseData();
			//调用删除用户方法，删除用户信息
			data.deleteUser(new User(id));
		}
		//跳发跳转到显示servlet
		request.getRequestDispatcher("ShowUserServlet").forward(request, response);
	}

	
}
