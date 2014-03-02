<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h1>Index File</h1><br />
	<form action="spring-test-db/saveuser" method="post">
	<table>
		<tr>
			<td>Name : </td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>Age : </td>
			<td><input type="text" name="age"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit"/></td>
		</tr>
	</table>
	</form>
</body>
</html>