package hw4.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw4.service.MovieDbService;

@WebServlet("/AddMovie")
public class AddMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddMovie() {
        super();
       
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "/WEB-INF/AddMovie.jsp").forward( request, response ); //sending the information to the AddMovie to create form.
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		int releaseYear = Integer.parseInt(request.getParameter("releaseYear"));
		
		MovieDbService dbService = new MovieDbService();
		dbService.addMovieEntry(title, releaseYear);
		dbService.close();
		response.sendRedirect("DisplayMovies");
	}
}
