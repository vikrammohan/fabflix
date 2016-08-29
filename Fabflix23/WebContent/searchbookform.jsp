<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search Movies</title>

</head>

<body>

<form method="post" action="searchbook.jsp">

<table>

<tr>

<td>Search:</td>

<td><input type="text" name="title" size="10" /></td>

<td>Genres:</td>

<td><select name="genres">

<option value="-1">-Select Category-</option>
<option value="action">Action</option>

<option value="SCI/Fi">SCI/FI</option>

<option value="Crime/Gangster">Crime/Gangster</option>

<option value="Epics/Historical">Epics/Historical</option>

<option value="Science Fiction/Fantasy">Science Fiction/Fantasy</option>

<option value="Musical/Performing Arts">Musical/Performing Arts</option>

<option value="Romance">Romance</option>

<option value="Spy">Spy</option>

<option value="Horror">Horror</option>

</select></td>

<td><input type="submit" value="Search Movies" /></td>

</tr>

</table>

</form>

</body>

</html>