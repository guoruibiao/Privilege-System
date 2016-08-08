<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户显现与系统权限展示</title>
</head>
<body>
	<table frame="border" width="40%" border="1px solid #123">
		<tr>
			<td>角色名称</td>
			<td>${role.name }</td>
		</tr>
		<tr>
			<td>角色当前拥有的权限</td>
			<td><c:forEach items="${rolePrivileges }" var="rp">
					${rp.name }<br>
				</c:forEach></td>
		</tr>
		<tr>
			<td>系统内所有权限</td>
			<form
				action="${pageContext.request.contextPath }/servlet/AddRolePrivilegeServlet"
				method="post">
				<!-- 为了告诉Servlet为哪个角色添加权限，所以需要携带角色的ID -->
				<input type="hidden" name="role_id" value="${role.id }">
				<td><c:forEach items="${systemPrivileges }" var="sp">
						<input type="checkbox" name="privilege_id" value="${sp.id }">${sp.name }<br>
					</c:forEach> <br> <input type="submit" value="确认添加"></td>
			</form>
		</tr>
	</table>

</body>
</html>