package hw4.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hw4.model.User;
import hw4.service.MovieDbService;



@WebServlet(urlPatterns="/DisplayMovies", loadOnStartup = 1)
public class DisplayMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DisplayMovies() {
        super();
        
    }


	public void init(ServletConfig config) throws ServletException {
		super.init( config );
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MovieDbService dbService = new MovieDbService();
		
		request.getSession(false).getAttribute("userSession"); //calling session and setting attribute
		String userName = (String) request.getSession(false).getAttribute("userName"); //setting a session for userName
		request.setAttribute("entries", dbService.getMovieEntries()); //database service method to show the movies
		request.setAttribute("users", dbService.getUser(userName)); //database service method to retrieve user and check for unique name based on userName attribute
		request.setAttribute("clearance", dbService.retrieveClearance(userName)); //database service method to get the clearance level integer for userName attribute from session
	
		dbService.close();
		
		request.getRequestDispatcher( "/WEB-INF/DisplayMovies.jsp" ).forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
