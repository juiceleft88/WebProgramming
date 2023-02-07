package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
import model.Vet;


@WebServlet(urlPatterns="/DisplayVets", loadOnStartup=1)
public class DisplayVets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisplayVets() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		Vet vet = new Vet("Purrfect Paws"); //creating new instance of Vet to create a new clinic
		vet.getPatientName().add(new Animal("Shelly the Turtle")); //adding the individual patients to patientName list in vet object
		vet.getPatientName().add(new Animal("Ronny the Rat"));
		List<Vet>vetList = new ArrayList<Vet>(); //creating a list of Vets
		vetList.add(vet); //add in the first created vet to the list of vets
		
		vet = new Vet ("RuffHouse Care");
		vet.getPatientName().add(new Animal("Fred the Dog"));
		vet.getPatientName().add(new Animal("Molly the Marsupial"));
		vetList.add(vet);
		
		vet = new Vet ("OceanGrove Vet Clinic");
		vet.getPatientName().add(new Animal("Roger the Rabbit"));
		vet.getPatientName().add(new Animal("Tory the Tarantula"));
		vetList.add(vet);
		
		getServletContext().setAttribute("vetList", vetList); //setting the list of vets in request scope
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int vetId = 1; //setting the vetId to 1 so there is always an id
		
		if(request.getParameter("vetId") != null) //as long as the vetId paramter is not null, assign that  number to the vetId variable
			vetId = Integer.parseInt(request.getParameter("vetId"));
		
		@SuppressWarnings("unchecked")
		List<Vet> vetList = (List<Vet>)getServletContext().getAttribute("vetList");
		
		for(Vet localVetVar : vetList) //creating a local variable to iterate through vetList and set vetId
		{
			if(localVetVar.getId() == vetId) //once localVetVar gets to the correct vetId
			{
				request.setAttribute("localVetVar", localVetVar); //set the local vet variable in application scope to use in jsp
				break;
			}
		}

		
		
		
		request.getRequestDispatcher( "/WEB-INF/DisplayVets.jsp") //sending the information to the BoxOffice to create form
        .forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
