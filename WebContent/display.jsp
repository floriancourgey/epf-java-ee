<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.formation.entity.*"%>
<html>
<head>
<title>User Display</title>
</head>
<body>
	<table>
	<tr>
		<th>id</th>
		<th>login</th>
		<th>password</th>
	</tr>
	<c:forEach items="${requestScope.users}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.login}</td>
			<td>${user.password}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>