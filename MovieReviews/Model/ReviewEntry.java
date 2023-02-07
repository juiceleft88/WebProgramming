package hw4.model;

public class ReviewEntry {

		private int id;
		private int movieId;
		private String userName;
		private int rating;
		private String review;
		
		
		public ReviewEntry() {

		}

		public ReviewEntry(int id, String userName, int rating, String review, int movieId) {
			this();
			this.id = id;
			this.userName = userName;
			this.rating = rating;
			this.review = review;
			this.movieId= movieId;
		}
		

		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		public String getReview() {
			return review;
		}
		public void setReview(String review) {
			this.review = review;
		}
		 public int getId() {
		    return id;
		}
		 public void setId(int id) {
		    this.id = id;
		 }
		 public int getMovieId() {
		    return movieId;
		 }
		 public void setMovieId(int movieId) {
		    this.movieId = movieId;
		 }


	}

	


