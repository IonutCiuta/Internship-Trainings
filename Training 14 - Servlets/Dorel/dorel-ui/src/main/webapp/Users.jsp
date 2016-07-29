<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DOREL UI</title>
</head>
<body>

	<table>
		<c:forEach items="${requestScope.userList}" var="user">
			<tr>
				<td>Id: <c:out value="${user.id}"></c:out></td>
				<td>User: <c:out value="${user.user}"></c:out></td>
				<td><a href="user?id=${user.id}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<button type="button" onclick="window.location='/dorel-ui';">Home</button>

</body>
</html>