<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DOREL UI</title>
</head>
<body>
	<p>${requestScope["randomAttribut"]}</p>
	<p>${pageContext.request.contextPath}</p>
	<p>${header["user-agent"]}</p>

	<br>
	<button type="button" onclick="window.location='/dorel-ui';">Home</button>
</body>
</html>