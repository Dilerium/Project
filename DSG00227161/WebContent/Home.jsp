<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session = "true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>I want to make a fibo thingie cause magicals are greats for the healths.</title>
</head>
<body>
	<form action="FibServlet">
		<% session.setAttribute("request-type", "Add"); %>
		<label>Please enter number between 1 and 100</label><br>
		<input type="text" name="number" size="20px">
		<input type="submit" value="submit">
	</form>
</body>
</html>