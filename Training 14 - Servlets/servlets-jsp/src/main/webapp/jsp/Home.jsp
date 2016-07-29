<%--
  Created by IntelliJ IDEA.
  User: iciuta
  Date: 7/29/2016
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Home</h2>
    <p>
        User: <b>${sessionScope.user.username}</b>
    </p>
    <p>
        <form action="${pageContext.request.contextPath}/home" method="post">
            <button type="submit" name="button" value="val1">Sign out</button>
            <button type="submit" name="button" value="val2">Delete user</button>
    </form>
    </p>
</body>
</html>
