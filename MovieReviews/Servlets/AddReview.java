package hw4.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import hw4.service.MovieDbService;


@WebServlet("/AddReview")
public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddReview() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		MovieDbService dbService = new MovieDbService();
		request.getSession(false).getAttribute("userSession");
		String userName = (String) request.getSession(false).getAttribute("userName");
		request.setAttribute("entry", dbService.getMovieEntry(id));
    	request.setAttribute("entries", dbService.getMovieEntries());
        dbService.close();
        
        request.getRequestDispatcher( "/WEB-INF/AddReview.jsp" ).forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MovieDbService dbService = new MovieDbService();
		
		 String id = request.getParameter( "id" );
		 String strippedId = id.strip();
		 String userName = request.getParameter("userName");
	     int rating = Integer.parseInt(request.getParameter("rating"));
	     String review = request.getParameter("review");
	     int movId = Integer.parseInt(strippedId);
	   
	        
	  
	      dbService.addReviews(movId, userName, rating, review);
	      dbService.close();

	      response.sendRedirect( "DisplayReviews?id="+movId );
	}

}
