package model;

import java.util.ArrayList;
import java.util.List;

public class Vet {
	
	static private int idSeed = 1; 
	private int id;
	private String vetName; //to hold the name of vets that will populate dropdown list
	private List<Animal>patientName; //to hold the list of animal patients
	
	public Vet(String vetName) {
		this.id = idSeed++;
		this.vetName = vetName;
		patientName = new ArrayList<Animal>(); //inititalizing array so it will not be null
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVetName() {
		return vetName;
	}
	public void setVetName(String vetName) { //setting the vetName
		this.vetName = vetName;
	}
	public List<Animal> getPatientName() { //returns the list of animal patient names/types
		return patientName;
	}
	public void setPatientName(List<Animal> patientName) {
		this.patientName = patientName;
	}
	
	public void treatedAnimals(int animalId) { //function to return the case where an animal has been treated, using boolean flag from Animal class
		for(Animal animals : patientName) { //iterating through the list of patients
			if(animals.getId() == animalId) //if both ids match, then set the boolean flag to true
			{
				animals.setIsTreated(true);
				break;
			}
		}
	}

}
