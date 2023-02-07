<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Register Display</title>


</head>
<body>
<h2>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="DisplayMovies">Movies</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Register</li>
  		</ol>
	</nav>
	</h2>
<h2> Please register for an account here:</h2>
<form action='Register' method='post'>
  <div class="mb-3">
    <label for="inputfullName" class="form-label">Enter full name:</label>
    <input type="text" class="form-control" name = "create_fullName" id="create_fullName">
  </div>

  <div class="mb-3">
    <label for="inputuserName" class="form-label">Enter a user name:</label>
    <input type="text" class="form-control" name = "create_userName" id="create_userName">
  </div>
  <div class="mb-3">
    <label for="inputpassWord" class="form-label">Create a Password:</label>
    <input type="text" class="form-control" name = "create_password" id="create_password">
  </div>
  <button type="submit" class="btn btn-primary">Create Account</button>
</form>

Already registered? Click <a href = 'Login'>here</a> to go back to the login page.


</body>
</html>

