<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加角色页面</title>
</head>
<body>
<form
		action="${pageContext.request.contextPath }/servlet/AddRoleServlet"
		method="post">
		角色名称：<input type="text" name="name"> <br>角色描述：
		<textarea rows="5" cols="50" name="description"> </textarea>
		<br> <input type="submit" value="添加角色">
	</form>
</body>
</html>