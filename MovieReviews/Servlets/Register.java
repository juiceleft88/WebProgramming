package hw4.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw4.model.User;
import hw4.service.MovieDbService;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher( "/WEB-INF/Register.jsp").forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//to process the form data
		String fullName = request.getParameter("create_fullName");
		String userName = request.getParameter("create_userName");
		String password = request.getParameter("create_password");
		int clearance = 1; //any user who registers through this application will automatically be a regular user, and so their clearance will automatically be a level 1. Admin users are only added by us directly in table
		
		MovieDbService dbService = new MovieDbService();
		//if the inputted userName already exists in the database, then send to error page, since each userName must be unique
		if(dbService.userNameDoesntExist(userName) == false) {
			request.getRequestDispatcher( "/WEB-INF/ErrorPage.jsp").forward( request, response );
		}
		
		dbService.addUsers(fullName, userName, password, clearance); //otherwise, add the user
		
		dbService.close();
		response.sendRedirect("Login"); //after the user is added, redirect them to login so they can use their credentials to login
	}

}
