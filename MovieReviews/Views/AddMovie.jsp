<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>AddMovie</title>
</head>
<body>
	<h2>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="DisplayMovies">Movies</a></li>
		    <li class="breadcrumb-item active" aria-current="page">New Movie</li>
  		</ol>
	</nav>
	</h2>
	
	<form action = 'AddMovie' method = 'post'>
  		<div class="row mb-3">
    		<label for="titleinput" class="col-sm-2 col-form-label">Title:</label>
	    	<div class="col-sm-10">
	      		<input type="text" class="form-control" name="title">
	    	</div>
  		</div>
  		<div class="row mb-3">
    		<label for="titleinput" class="col-sm-2 col-form-label">Year:</label>
	    	<div class="col-sm-10">
	      		<input type="text" class="form-control" name="releaseYear">
	    	</div>
  		</div>
  		 <button type="submit" class="btn btn-primary">Add Movie</button>
	</form>
  
</body>
</html>

