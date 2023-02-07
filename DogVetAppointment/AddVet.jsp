<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Vet</title>
</head>
<body>
<form action="AddVet" method="post"> <!-- simply creating a form to process the inputted name of vet -->
Name: <input type="text" name="vetName">
	<button type="submit">Add Vet</button>
</form>
</body>
</html>
