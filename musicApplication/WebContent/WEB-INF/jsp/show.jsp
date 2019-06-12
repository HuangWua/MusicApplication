<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询用户</title>
</head>
<body>
	<form name="userForm"
		action="${pageContext.request.contextPath }/user/findUserList.action"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td>用户名称：<input name="userCustom.name" />
				</td>
				<td><input type="submit" value="查询" />
			</tr>
		</table>
		用户列表：
		<table width="100%" border=1>
			<tr>
				<!-- <td>选择</td> -->
				<td>用户名称</td>
				<td>用户价格</td>
				<!-- <td>生产日期</td> -->
				<td>用户描述</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${userList }" var="user">
				<tr>
					<%-- <td><input type="checkbox" name="items_id" value="${item.id}" />
					</td> --%>
					<td>${user.name }</td>
					<td>${user.password }</td>
					<%-- <td><fmt:formatDate value="${user.createtime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td> --%>
					<td>${user.details }</td>

					<td><a
						href="${pageContext.request.contextPath }/user/editUser.action?id=${user.id}">修改</a>
					</td>

				</tr>
			</c:forEach>

		</table>
	</form>
</body>
</html>