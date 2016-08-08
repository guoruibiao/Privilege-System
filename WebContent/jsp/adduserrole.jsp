<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户角色细节显示</title>
</head>
<body>
	<table frame="border" width="40%" border="1px solid #123">
		<tr>
			<td>用户名称</td>
			<td>${user.username }</td>
		</tr>
		<tr>
			<td>用户当前拥有的角色属性</td>
			<td><c:forEach items="${userroles }" var="userrole">
					${userrole.name }<br>
				</c:forEach></td>
		</tr>
		<tr>
			<td>系统内所有角色信息</td>
			<form
				action="${pageContext.request.contextPath }/servlet/AddUserRoleServlet"
				method="post">
				<!-- 为了告诉Servlet为哪个角色添加权限，所以需要携带角色的ID -->
				<input type="hidden" name="user_id" value="${user.id }">
				<td><c:forEach items="${systemroles }" var="sysrole">
						<input type="checkbox" name="role_id" value="${sysrole.id }">${sysrole.name }<br>
					</c:forEach> <br> <input type="submit" value="确认添加"></td>
			</form>
		</tr>
	</table>

</body>
</html>