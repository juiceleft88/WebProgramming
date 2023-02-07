package hw4.model;

import java.util.ArrayList;
import java.util.List;

import hw4.service.MovieDbService;



public class MovieEntry {
	
	private int id;
	private int ratingScore;
	private String title;
	private int releaseYear;
	private List<ReviewEntry> reviews;

	
	public MovieEntry() { //no longer need parameters, can use empty constructor
		reviews = new ArrayList<ReviewEntry>();
	}
	
	public MovieEntry(int id, String title, int releaseYear, int ratingScore)
	{
		this();
		this.id =id;
		this.title = title;
		this.releaseYear = releaseYear;
		this.ratingScore = ratingScore; //to use the database values
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public List<ReviewEntry> getReviews() {
	    return reviews;
	}
	public void setReviews(List<ReviewEntry> reviews) {
	    this.reviews = reviews;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	
	public int getRatingScore() {
		
		return ratingScore;
	}

	public void setRatingScore(int ratingScore) {
		this.ratingScore = ratingScore;
	}

	
	public String getReviewSummary()
	{
		MovieDbService revEntries = new MovieDbService();
		if(revEntries.getMovieReviews(this.id).size() == 0 ) //if size of array containing movie reviews is empty (or is one of the default values inputted into table)
		{
			return "N/A"; //then print "N/A"
		}
		else //otherwise
		{
			double sum = 0.0;
	        for(ReviewEntry review : revEntries.getMovieReviews(this.id)) //for each review in the review list
	        {
	            sum+=review.getRating(); //set the sum to the getRating function from ReviewEntry class
	        }
	        double avgRating = sum / revEntries.getMovieReviews(this.id).size(); //then set the avgRating to the sum value, divided by the number of entries in reviews array
	        return String.format("%2.2f", avgRating); //format the output
		}
		
	}
	

}
