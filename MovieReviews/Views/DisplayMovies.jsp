<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Movie Display</title>
</head>
<body>
	<c:choose>
    	<c:when test="${sessionScope.clearance == '2'}">
         	<button type="button" class="btn btn-outline-success" disabled>Administrator</button>
   		 </c:when>    
	</c:choose>
	<c:choose>
    	<c:when test="${sessionScope.clearance == '1'}">
          	<button type="button" class="btn btn-outline-success" disabled>Regular User</button>
    	</c:when>    
	</c:choose>
	
	<c:choose>
    	<c:when test="${sessionScope.userName != null}">
        	<a class="btn btn-danger" href='Logout' role="button">Logout</a>
    	</c:when>    
    	<c:otherwise>
    		<a class="btn btn-secondary" href='Login' role="button">Login</a>	| <a class="btn btn-secondary" href='Register' role="button">Register</a>
    	</c:otherwise>
	</c:choose>

<h1>Movies</h1>
	 <c:choose>
    	<c:when test="${sessionScope.clearance == '2'}">
        	<a class="btn btn-primary" href='AddMovie' role="button">Add Movie</a>
        <br />
    </c:when>    
	</c:choose>
	 <c:choose>
    	<c:when test="${sessionScope.clearance != '2'}">
        	<a class="btn btn-primary" href='Denied' role="button">Add Movie</a>
        <br />
    </c:when>    
	</c:choose>
	


    <table class="table">
  	<thead>
    	<tr>
      	<th scope="col">Title</th>
      	<th scope="col">Year</th>
      	<th scope="col">Avg Rating</th>
    	</tr>
  	</thead>
       
      <tbody>
     <c:forEach items = "${entries}" var ="entry" >
 
			<tr>
            <td><a href="DisplayReviews?id=${entry.id}">${entry.title}</a></td>
            <td> ${entry.releaseYear}</td>
            <td> ${entry.getReviewSummary()} </td>
            </tr>

     </c:forEach>
		</tbody>
		

    </table>
</body>
</html>

