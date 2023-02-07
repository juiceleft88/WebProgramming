package hw4.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hw4.model.User;
import hw4.service.MovieDbService;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher( "/WEB-INF/Login.jsp").forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession userSession = request.getSession(true); //setting the session, to be used for correct logins
		
		String userName = request.getParameter("userName"); //processing the login info
		String password = request.getParameter("password");
		
		MovieDbService dbService = new MovieDbService(); //creating a database service object
		
		//if the processed form login credentials match those in our database
		if(dbService.credentialsMatch(userName, password) == true ) {
			//then set a session for that given username, as well as for the clearance level, then redirect the succesful login back to the main movie display page
			userSession.setAttribute("userSession", userSession);
			userSession.setAttribute("userName", userName);
			userSession.setAttribute("clearance", dbService.retrieveClearance(userName));
			response.sendRedirect("DisplayMovies");
		}
		//if the processed form login credentials DO NOT match those in our database
		else if(dbService.credentialsMatch(userName, password) == false){
			//then redirect immediately to the error page
			request.getRequestDispatcher( "/WEB-INF/ErrorPage.jsp").forward( request, response ); 
		}
		dbService.close();
		
		

		
	}

}
