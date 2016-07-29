<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<c:if test="${!requestScope.userFound}">
		<h1>c:if does not have else in it :)), so you have to use choose or multiple c:if</h1>
	</c:if>

	<c:choose>
		<c:when test="${requestScope.userFound}">
			<c:set var="userVar" scope="session" value="${requestScope.user}" />

			<form action="${pageContext.request.contextPath}/user" method="post">
				<p>
					User: <input type="text" name="userName" value="${userVar.user}">
				</p>
				<p>
					Password: <input type="text" name="userPass"
						value="${userVar.pass}">
				</p>
				<input type="hidden" name="userId" value="${userVar.id}"> <input
					type="submit" value="Update user">
			</form>
		</c:when>
		<c:otherwise>
			<h1>User not found, check logs</h1>
		</c:otherwise>
	</c:choose>

	<br>
	<a href="/dorel-ui/users-method">Back</a>
	<br>

	<button type="button" onclick="window.location='/dorel-ui';">Home</button>

</body>
</html>