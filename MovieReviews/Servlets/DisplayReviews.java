package hw4.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw4.service.MovieDbService;


@WebServlet("/DisplayReviews")
public class DisplayReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DisplayReviews() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id")); //

		MovieDbService dbService = new MovieDbService(); //creating an object for the database service
		request.getSession(false).getAttribute("userSession"); //calling session
		String userName = (String) request.getSession(false).getAttribute("userName"); //setting session attribute "userName" to local variable to be used as an argument for db service function
		request.setAttribute("entry", dbService.getMovieEntry(id));  //to get the unique id for movie entry!!
		request.setAttribute("revEntries", dbService.getMovieReviews(id)); //to show the reviews based on the movie id
		request.setAttribute("clearance", dbService.retrieveClearance(userName)); //to get the clearance integer for the given "userName"
		dbService.close();
		
		request.getRequestDispatcher( "/WEB-INF/DisplayReviews.jsp" ).forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
