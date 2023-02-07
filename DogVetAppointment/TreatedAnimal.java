package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Vet;


@WebServlet("/TreatedAnimal")
public class TreatedAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public TreatedAnimal() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vetId = Integer.parseInt(request.getParameter("vetId"));
		
		@SuppressWarnings("unchecked")
		List<Vet> vetList = (List<Vet>)getServletContext().getAttribute("vetList");
		 Vet vet = vetList.get(0); //since the vetId starts at 1, we can set to 0 for a new animal
		
		for(Vet localVetVar : vetList) //creating a local variable to iterate through vetList and set vet object (kind of confusing ?)
		{
			if(localVetVar.getId() == vetId) //once localVetVar gets to the correct vetId
			{
				vet = localVetVar; 
				break;
			}
		}
		
		vet.treatedAnimals(Integer.parseInt(request.getParameter("animalId"))); //set the vetId parameter as an argument for treatedAnimals
		response.sendRedirect("DisplayVets?vetId=" + vet.getId());
	}



}
