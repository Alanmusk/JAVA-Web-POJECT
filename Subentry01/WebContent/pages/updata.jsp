<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="UpdataUserServlet" method="post">
		<table border="1" class="t1">
			<tr>
				<td colspan="2"><h1>修改用户信息</h1></td>
			</tr>
			<c:forEach items="${list}" var="item">
			<tr>
				<td>编号:</td>
				<!-- 在某个表单中为用户预填了某个唯一识别代码，不允许用户改动，但是在提交时需要传递该值，此时应该将它的属性设置为readonly。 -->
				<td><input type="text" name="id" value="${item.id}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>用户账号:</td>
				<td><input type="text" name="username" value="${item.username}"></td>
			</tr>
			<tr>
				<td>用户密码:</td>
				<td><input type="text" name="userpwd" value="${item.userpwd}"></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交">
					<!-- history.go(-1)返回且刷新页面 点击返回上一层 -->
					<input type="button" value="返回" onclick="history.go(-1)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>