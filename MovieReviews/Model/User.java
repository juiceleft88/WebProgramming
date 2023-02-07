package hw4.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	public int userId;
	public String userName;
	public String fullName;
	public String password;
	public int clearance;
	public List<User> users;
	
	public User() {
	
	List<User> users = new ArrayList<User>();
		
	}
	
	public User(String userName, String fullName, String password, int clearance) {
		this.userId = userId;
		this.clearance = clearance;
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClearance() {
		return clearance;
	}

	public void setClearance(int clearance) {
		this.clearance = clearance;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	

}
