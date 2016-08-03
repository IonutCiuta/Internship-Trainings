<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Web Fundamentals - Signin App">
    <meta name="author" content="Florin Stancu">

    <title>Web Fundamentals - Signin App</title>

    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/login.css"/>" rel="stylesheet">
</head>
<body>
    <div class="container">
        <form class="form-signin" method="POST" action="<c:url value="/user/login"/>">
            <h2 class="form-signin-heading">Authentication</h2>

            <c:if test="${not empty message}">
                <div class="alert alert-danger">${message}</div>
            </c:if>

            <label for="inputUsername" class="sr-only">Username</label>
            <input name="username" type="text" id="inputUsername" class="form-control" placeholder="Username" required autofocus>

            <label for="inputPassword" class="sr-only">Password</label>
            <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        </form>
    </div>
</body>
</html>