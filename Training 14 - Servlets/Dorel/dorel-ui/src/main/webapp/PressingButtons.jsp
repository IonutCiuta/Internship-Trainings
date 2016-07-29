<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DOREL UI</title>
</head>
<body>

	<form
		action="${pageContext.request.contextPath}/pressing-buttons-method"
		method="post">
		<button type="submit" name="button" value="button1">Button 1</button>
		<button type="submit" name="button" value="button2">Button 2</button>
		<button type="submit" name="button" value="button3">Button 3</button>
	</form>

	<button type="button" onclick="window.location='/dorel-ui';">Home</button>

</body>
</html>