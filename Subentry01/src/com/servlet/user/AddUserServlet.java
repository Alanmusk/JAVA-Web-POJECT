package com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BaseData;
import com.entity.User;

public class AddUserServlet extends HttpServlet{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	/*设置表单提交方式*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println(">>> user add");
		
		/*获取页面输入信息*/
		//用户名
		String username = request.getParameter("username");
		//用户密码
		String userpwd = request.getParameter("userpwd");
		//创建用户对象
		User user = new User();
		/*把通过页面获取的信息进行乱码处理后，存储到user对象中。*/
		//用户名信息
		user.setUsername(new String(username.getBytes("ISO-8859-1"),"UTF-8"));
		//用户密码信息
		user.setUserpwd(new String(userpwd.getBytes("ISO-8859-1"),"UTF-8"));
		System.out.println(user.getUsername());
		System.out.println(user.getUserpwd());
		//创建用户数据操作对象
		BaseData data = new BaseData();
		//调用添加方法，添加用户信息
		 data.addUser(user);
		//跳发跳转到显示servlet
		request.getRequestDispatcher("ShowUserServlet").forward(request, response);
	}
}
