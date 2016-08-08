<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息罗列</title>
</head>
<body style="text-align: center;">
	<table width="50%">
		<tr align="right">
			<td><a
				href="${pageContext.request.contextPath }/jsp/adduser.jsp">添加用户</a></td>
		</tr>
	</table>

	<table frame="border" width="50%">
		<tr>
			<td>用户名称</td>
			<td>用户密码</td>
			<td>操作</td>
		</tr>
		<c:forEach var="user" items="${ users }">
			<tr>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td><a href="#">修改用户</a> <a href="#">删除用户</a> <a
					href="${pageContext.request.contextPath }/servlet/AddUserRoleUIServlet?user_id=${user.id}">为用户授予角色</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>