<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有权限罗列</title>
</head>
<body style="text-align: center;">
	<table width="50%">
		<tr align="right">
			<td><a href="${pageContext.request.contextPath }/jsp/addprivilege.jsp">添加权限</a></td>
		</tr>
	</table>

	<table frame="border" width="50%">
		<tr>
			<td>权限名称</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		<c:forEach var="privilege" items="${ privileges }">
			<tr>
				<td>${privilege.name }</td>
				<td>${privilege.description }</td>
				<td>
					<a href="#">修改权限</a>
					<a href="#">删除权限</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>