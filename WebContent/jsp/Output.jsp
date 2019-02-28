<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Output</title>
</head>
<body>

	<h3>Student & College Info:</h3>
	
<%= session.getAttribute("name") %><br>
<%= session.getAttribute("add") %><br>
<%= session.getAttribute("phone") %><br>
<%= session.getAttribute("sid") %><br>
<%= session.getAttribute("course") %><br></h1>
</body>
</html>