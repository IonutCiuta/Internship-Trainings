<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <h2>Sign Up</h2>
    <form action="${pageContext.request.contextPath}/" method="post">
        <p>
            User: <input type="text" name="username">
        </p>
        <p>
            Password: <input type="password" name="password">
        </p>
        <p>
            <input type="submit" value="Submit" />
        </p>
    </form>

    <c:if test="${requestScope.usernameError}">
        <h3>Username must have at least 3 characters!</h3>
    </c:if>

    <c:if test="${requestScope.passwordError}">
        <h3>Password must have at least 3 characters!</h3>
    </c:if>
</body>
</html>
