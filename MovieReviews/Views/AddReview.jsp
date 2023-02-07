<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Add Review</title>
</head>
<body>
	
	<h2>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="DisplayMovies">Movies</a></li>
		    <li class="breadcrumb-item"><a href="DisplayReviews?id=${entry.id}">${entry.title}</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Add Review</li>
  		</ol>
	</nav>
	</h2>


	<form action = "AddReview?id=${entry.id}" method = 'post'> 

  			<div class="row mb-3">
    			<label for="name" class="col-sm-2 col-form-label">UserName:</label>
    				<div class="col-sm-10">
      					<input type="text" class="form-control" name="userName" value="${sessionScope.userName}">
    				</div>
  			</div>
  
  
	  <fieldset class="row mb-3">
	    <legend class="col-form-label col-sm-2 pt-0">Rating:</legend>
	    <div class="col-sm-10">
	      <div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="rating" id="rating1" value="1">
			  <label class="form-check-label" for="rating1">1</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="rating" id="rating2" value="2">
			  <label class="form-check-label" for="rating2">2</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="rating" id="rating3" value="3">
			  <label class="form-check-label" for="rating3">3</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="rating" id="rating4" value="4">
			  <label class="form-check-label" for="rating4">4</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="rating" id="rating5" value="5">
			  <label class="form-check-label" for="rating5">5</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="rating" id="rating6" value="6">
			  <label class="form-check-label" for="rating6">6</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="rating" id="rating7" value="7">
			  <label class="form-check-label" for="rating7">7</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="rating" id="rating8" value="8">
			  <label class="form-check-label" for="rating8">8</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="rating" id="rating9" value="9">
			  <label class="form-check-label" for="rating9">9</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="rating" id="rating10" value="10">
			  <label class="form-check-label" for="rating10">10</label>
			</div>
	    </div>
	  </fieldset>
  
	  <div class="mb-3">
	  	<label for="review" class="form-label">Review:</label>
	  	<textarea class="form-control" name="review" rows="3"></textarea>
	  </div>
  
  
 	 <button type="submit" class="btn btn-primary">Add Review</button>
	</form>
</body>
</html>
