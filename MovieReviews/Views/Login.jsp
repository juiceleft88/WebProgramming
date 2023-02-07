<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Login Display</title>


</head>
<body>
<h2>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="DisplayMovies">Movies</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Login</li>
  		</ol>
	</nav>
	</h2>
<h2>Please login using your registration userName and password below:</h2>
<form action = 'Login' method = 'post'>
  <div class="mb-3">
    <label for="inputuserName" class="form-label">Username:</label>
    <input type="text" class="form-control" name="userName">
  </div>
  <div class="mb-3">
    <label for="inputpassWord" class="form-label">Password:</label>
    <input type="text" class="form-control" name="password">
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
</form>

	</div> <a href="Register">Not Registered? Click Here</a> 

</body>
</html>

