package model;

public class Animal {
	static private int idSeed = 1;
	private int id;
	private String patient;
	private Boolean isTreated;

	public Animal(String patient) { //this constructor only holds the string of the patient name or species, as well as the boolean flag set to default false
		this.id = idSeed++;
		this.patient = patient;
		this.isTreated = false;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public Boolean getIsTreated() {
		return isTreated;
	}

	public void setIsTreated(Boolean isTreated) {
		this.isTreated = isTreated;
	}
	
	

}
