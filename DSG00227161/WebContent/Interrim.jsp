<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html; charset = ISO-8859-1">
<meta http-equiv = "refresh" content = ${ timer }>
<title>Waiting on Results</title>
</head>
<body>
	<form action="FibServlet">
		<input type="hidden" name="request-type" value="Poll">
		<label>Job Number: ${ jobNumber }</label><br>
		<label>This page will refresh in ${ timer } seconds.</label>
	</form>
</body>
</html>