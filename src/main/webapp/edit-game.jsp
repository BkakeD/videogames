<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Game</title>
</head>
<body>

	<form action = "editGameServlet" method="post">
		Game: <input type="text" name="name" value="${gameToEdit.name}">
		Developer: <input type="text" name="developer" value="${gameToEdit.developer}">
		Publisher: <input type="text" name="publisher" value="${gameToEdit.publisher}">
		<input type="hidden" name="id" value="${gameToEdit.id}">
		<input type="submit" value="Save Edited Game">
	</form>

</body>
</html>