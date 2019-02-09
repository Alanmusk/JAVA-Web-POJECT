<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面数据测试</title>
</head>
<body>
	<%
		//post提交方式：请求和响应中文乱码处理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取用户数据
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
	%>
	用户名：<%=username %><br/>
	用户名：<%=userpwd %>
</body>
</html>