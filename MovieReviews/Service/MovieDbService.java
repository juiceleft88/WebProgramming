package hw4.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import hw4.model.MovieEntry;
import hw4.model.ReviewEntry;
import hw4.model.User;


public class MovieDbService {
	
	 private String url = "jdbc:mysql://127.0.0.1:3306/sys";
	 private String username = "movieDbUser";
	 private String password = "moviePass123";
	 private Connection connection;
	    
	 public MovieDbService()
	    {
	        try
	        {
	            connection = DriverManager.getConnection( url, username, password );
	        }
	        catch( SQLException e )
	        {
	            e.printStackTrace();
	        }
	    }

	    public void close()
	    {
	        if( connection != null )
	        {
	            try
	            {
	                connection.close();
	            }
	            catch( SQLException e )
	            {
	                e.printStackTrace();
	            }
	        }
	    }
	        
	    public List<MovieEntry> getMovieEntries() //need to get reviews per movie before the summary function will work
	    {
	    	List<MovieEntry> movEntries = new ArrayList<MovieEntry>();
	    	
	    	
	    	try
	    	{
	    		Statement stmt = connection.createStatement(); // creates object to send SQL statements to database
	            ResultSet rs = stmt.executeQuery("select * from movies2"); //executes the query that is given in string form, and returns a single resultSet object
	            
	            while(rs.next()) //while there is a next entry, do the following:
	            {
	            	MovieEntry entry = new MovieEntry(); //creating a movieEntry object to set parameters
	            	entry.setId(rs.getInt("id")); 
	            	entry.setTitle(rs.getString("title")); 
	            	entry.setReleaseYear(rs.getInt("releaseYear"));
	            	entry.setRatingScore(rs.getInt("ratingScore"));
	            	movEntries.add(entry); //adding the newly made object into the list of movieEntry objects
	            }
	            stmt.close(); //releasing this statement objects JDBC and database resources immediately
	    	}
	    	
	            catch( SQLException e )
	            {
	                e.printStackTrace();
	            }
	    	
	    	return movEntries; //return the list of movies
	    	
	    }
	    
	    public MovieEntry getMovieEntry(int id)
	    {
	    	MovieEntry entry = new MovieEntry(); //new movieEntry Object
	    	try 
	    	{
	    		String sql = "select * from movies2 where id=?";
	    		PreparedStatement pstmt = connection.prepareStatement(sql); //preparedStatement object used to efficiently execute this statement multiple times. connection part creates a preparedStatemet object for sending parameterized sql statements to the database
	    		pstmt.setInt(1, id); //sets the designated  parameter to the given Java int value
	    		ResultSet rs = pstmt.executeQuery(); //Executes the sql query in this preparedStatment object and returns the ResultSet object generated by the query
	    		if(rs.next())
	    		{
	    			entry.setId(rs.getInt("id")); //setting the parameters
	            	entry.setTitle(rs.getString("title")); 
	            	entry.setReleaseYear(rs.getInt("releaseYear"));
	    		}
	    		pstmt.close();
	    	}
	    	catch( SQLException e ) //an exception object that provides information on a database access error or other errors
	        {
	            e.printStackTrace();
	        }
	    	return entry; //returns the MovieEntry object
	    	
	    }
	    

	    
	    public int addMovieEntry(String title, int releaseYear) //for movie Entries
	    {
	    	int id = 0;
	    	try
	    	{
	    		String sql = "insert into movies2 (title, releaseYear) values (?, ?)";
	    		PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //return gen keys indicates that the generated keys should be made available for retrieval
	    		pstmt.setString(1, title); //
	    		pstmt.setInt(2, releaseYear); //must put numbers in order here, not sure why yet
	    		pstmt.executeUpdate(); //executes the given SQL statement, which may be insert, update, or delete, or an sql statement that returns nothing
	    		ResultSet rs = pstmt.getGeneratedKeys(); //Retrieves any auto-generated keys created as a result of executing this Statement object
	    		if(rs.next()) id = rs.getInt(1); //if the next generated id is equal to the 1st
	    		pstmt.close(); //then close
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    	return id; //return id
	    }

	    
	    public int addReviews(int movie_id, String name, int rating, String review)
	    {
	    	int id = 0;
	    	try
	    	{
	    		String sql = "insert into reviews2 (movie_id, userName, rating, review) values (?, ?, ?, ?)";
	    		PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //return gen keys indicates that the generated keys should be made available for retrieval
	    		pstmt.setInt(1,  movie_id); //setting the prepared statements to be inserted into reviews
	    		pstmt.setString(2, name);
	    		pstmt.setInt(3, rating);
	    		pstmt.setString(4,  review);
	    		
	    		pstmt.executeUpdate(); //executes given sql statement
	    		ResultSet rs = pstmt.getGeneratedKeys(); //Retrieves any auto-generated keys created as a result of executing this Statement object
	    		if(rs.next()) id = rs.getInt(1);
	    		pstmt.close();
	    		
	    		
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    	return id;
	    }
	    
	    public List<ReviewEntry> getMovieReviews(int movie_id) //parameter here
	    {
	    	List<ReviewEntry> revEntries = new ArrayList<ReviewEntry>();
	    	
	    	
	    	
	    	try
	    	{	
	    		
	 
	    		String sql = "select * from reviews2 where movie_id = ?";
	    		PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //return gen keys indicates that the generated keys should be made available for retrieval
	    		pstmt.setInt(1, movie_id); //
	    		ResultSet rs = pstmt.executeQuery(); //where movieid =
	    		
	    		
	    		while( rs.next() )
	    		{
	    			ReviewEntry entry = new ReviewEntry();
	    			entry.setId(rs.getInt("id")); //setting the info for query
	    			entry.setMovieId(rs.getInt("movie_id"));
	    			entry.setUserName(rs.getString("userName"));
	    			entry.setRating(rs.getInt("rating"));
	    			entry.setReview(rs.getString("review"));
	    			
	    			revEntries.add(entry);
	    		}
	    	
	    		pstmt.close();
	    		
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    	return revEntries;
	    }
	    
	    public boolean userNameDoesntExist(String userName) {
	    
	    	boolean status = false;
	    	
	    	try
	    	{
	    		
	    		String sql = "select distinct screenName from users where screenName = ?";
		    	PreparedStatement pstmt = connection.prepareStatement(sql);
		    	pstmt.setString(1, userName);
		    	ResultSet rs = pstmt.executeQuery();
		    

		    	
		    	if(!rs.next())
		    	{
		    		status = true;
		    	}
		    	
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    	
	    	return status;
	    }
	    
	     public int addUsers(String fullName, String userName, String password, int clearance)
	    {
	    	int id = 0;
	   
	    	try
	    	{
	    		//if the username doesn't exist, then add them to the table
	    		if(userNameDoesntExist(userName) == true) {
	    		String sql = "insert into users (fullName, screenName, pass, clearance) values (?, ?, ?, ?)";
	    		PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //return gen keys indicates that the generated keys should be made available for retrieval
	    		pstmt.setString(1,  fullName); //setting the prepared statements to be inserted into reviews
	    		pstmt.setString(2, userName);
	    		pstmt.setString(3, password);
	    		pstmt.setInt(4,  clearance);
	    		
	    		pstmt.executeUpdate(); //executes given sql statement
	    		ResultSet rs = pstmt.getGeneratedKeys(); //Retrieves any auto-generated keys created as a result of executing this Statement object
	    		if(rs.next()) id = rs.getInt(1);
	    		pstmt.close();
	    		}

	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    	return id;
	    }
	     
	  public int retrieveClearance(String userName)
	     {	
		  //this method returns the clearance level associated with a userName
		  int clearance = 0;
	    	 
	    	 try 
		    	{
		    		String sql = "select clearance from users where screenName = ?";
		    		PreparedStatement pstmt = connection.prepareStatement(sql); //preparedStatement object used to efficiently execute this statement multiple times. connection part creates a preparedStatemet object for sending parameterized sql statements to the database
		    		pstmt.setString(1, userName); //sets the designated  parameter to the given Java int value
		    		ResultSet rs = pstmt.executeQuery(); //Executes the sql query in this preparedStatment object and returns the ResultSet object generated by the query
		    		if(rs.next()) //if there is a record
		    		{
		    			User user = new User(); 
		    			user.setClearance(rs.getInt("clearance")); //set user clearance to the input in table
		    			clearance = user.getClearance(); //set the local clearance variable to this number
		    		}
		    		pstmt.close();
		    	}
		    	catch( SQLException e ) //an exception object that provides information on a database access error or other errors
		        {
		            e.printStackTrace();
		        }
	    	 
			return clearance; //to return the proper clearance
	    	 
	     }
	     
	     
	     
	     public List<User> getUser(String userName) //returns a user in a list based on the username. Lets us add individual users to a list of users
		    {
		    	List<User> userEntries = new ArrayList<User>(); //new userEntries Object
		    	try 
		    	{
		    		String sql = "select * from users where screenName = ?"; //select all info in the table associated with a given userName
		    		PreparedStatement pstmt = connection.prepareStatement(sql); //preparedStatement object used to efficiently execute this statement multiple times. connection part creates a preparedStatemet object for sending parameterized sql statements to the database
		    		pstmt.setString(1, userName); //sets the designated  parameter to the given Java int value
		    		ResultSet rs = pstmt.executeQuery(); //Executes the sql query in this preparedStatment object and returns the ResultSet object generated by the query
		    		if(rs.next())
		    		{
		    			User user = new User(); //new User object to recieve all the new parameter data
		    			user.setUserId(rs.getInt("id")); //setting the parameters
		    			user.setFullName(rs.getString("fullName"));
		            	user.setUserName(rs.getString("screenName"));
		            	user.setPassword(rs.getString("pass"));
		            	user.setClearance(rs.getInt("clearance"));
		            	userEntries.add(user); //adding this user to the list of users
		    		}
		    		pstmt.close();
		    		
		    	}
		    	catch( SQLException e ) //an exception object that provides information on a database access error or other errors
		        {
		            e.printStackTrace();
		        }
		    	return userEntries; //returns the userEntries object
		    	
		    }
	     
	     
	     public boolean credentialsMatch(String userName, String password)
	     {
	    	 //method to check if the inputted userName and password are stored in our table, and thus, valid
	    	 boolean match = false;
	    	 
	    	 try
		    	{
		    		
		    		String sql = "select * from users where screenName = ? and pass = ?";
			    	PreparedStatement pstmt = connection.prepareStatement(sql);
			    	pstmt.setString(1, userName);
			    	pstmt.setString(2, password);
			    	ResultSet rs = pstmt.executeQuery();

			    	
			    	if(rs.next()) //if there is a record, then must be true, else would be null
			    	{
			    		match = true;
			    	}
			    	pstmt.close();
		    	}
		    	catch(SQLException e)
		    	{
		    		e.printStackTrace();
		    	}
	    	 
	    	 
	    	 return match;
	     }
	     
	     
	

}
