<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert your billing information</title>
</head>
<body>
<form action = "CheckoutServlet" method="post">

<table>
<tr><td>Name: </td>
	<td><input type="text" name="nameOnCard"></td></tr>
<tr><td>Credit Card Number: </td>
	<td><input type="text" name="creditID"></td></tr>
<tr><td>Credit Card Expiration: </td>
	<td><input type="text" name="expiration"></td></tr>

<tr><td>Email Address: </td>
	<td><input type="text" name="emailAddress"></td></tr>

<tr><td>Password: </td>
	<td><input type="text" name="password"></td></tr>
</table>

<p>
<input type="submit" value="Complete Order">
</form>
</body>
</html>