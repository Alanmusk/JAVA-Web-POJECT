 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示主页面</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css"> 
</head>
<body>
	<table>
		<tr>
			<td>编号</td>
			<td>账号</td>
			<td>密码</td>
			<td>操作</td>
		</tr>
		 <c:forEach items="${list}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.username}</td>
				<td>${item.userpwd}</td>
				<!-- 超链接携带相关参数 -->
				<td><a href="DeleteUserServlet?id=${item.id}">删除</a>|<a href="UpdataUserServlet?id=${item.id}">修改</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" style="text-align:left;"><a href="${pageContext.request.contextPath }/pages/add.jsp">添加用户</a></td>
		</tr>
	</table>
</body>
</html>