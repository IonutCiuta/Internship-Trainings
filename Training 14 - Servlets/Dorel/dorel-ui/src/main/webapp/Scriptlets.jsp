<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DOREL UI</title>
</head>
<body>

	<%
		int i = 0;
		System.out.println("Using scriptlets is not a very nice thing to do!!!");
		for(i=0;i<10;i++) {
			//do something
		}
	%>
	
	<%=i %>

	<%
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		int hour = calendar.get(java.util.Calendar.HOUR_OF_DAY);
		if (hour < 12) {
	%>
	<h3>Good morning!</h3>
	<%
		} else {
	%>
	<h3>Good afternoon!</h3>
	<%
		}
	%>

	<button type="button" onclick="window.location='/dorel-ui';">Home</button>

	<%!public void jspInit() {
		System.out.println("Jsp init");
	}

	public void jspDestroy() {
		System.out.println("Jsp destroy");
	}%>

</body>
</html>