package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vet;


@WebServlet("/AddVet")
public class AddVet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddVet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher( "/WEB-INF/AddVet.jsp") //sending the information to the AddVet to create form
        .forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		List<Vet> vetList = (List<Vet>)getServletContext().getAttribute("vetList"); //getting the vetList attribute from application scope
		Vet vet = new Vet(request.getParameter("vetName")); //creating a new Vet object to add to list, where the argument is the vetName that gets filled out on form by user
		vetList.add(vet); //adding the newly-inputted vet object into list of vets
		response.sendRedirect("DisplayVets?vetId=" + vet.getId()); //redirecting back to the DisplayVets page using the vetId we get from the newly-made object
	}

}
