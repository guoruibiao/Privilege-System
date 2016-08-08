<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限业务导航</title>
</head>
<body>
	<ul>
		<li><a
			href="${pageContext.request.contextPath }/servlet/ListprivilegesServlet"
			target="body">权限管理</a></li>
		<li><a
			href="${pageContext.request.contextPath }/servlet/ListRoleServlet"
			target="body">角色管理</a></li>
		<li><a href="${pageContext.request.contextPath }/servlet/ListUsersServlet" target="body">用户管理</a></li>
	</ul>
</body>
</html>