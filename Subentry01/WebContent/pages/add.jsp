<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加页面</title>
</head>
	<!-- ${pageContext.request.contextPath}是JSP取得绝对路径的方法，等价于<%=request.getContextPath()%> 
	也就是取出部署的应用程序名或者是当前的项目名称 -->
	<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css"> 
<body>
	<form action="${pageContext.request.contextPath }/AddUserServlet" method="post">
		<table border="1" class="t1">
			<tr>
				<td colspan="2"><h1>添加用户</h1></td>
			</tr>
			<tr>
				<td>用户账号:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>用户密码:</td>
				<td><input type="password" name="userpwd"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="提交">
				<input type="button" value="清空">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>