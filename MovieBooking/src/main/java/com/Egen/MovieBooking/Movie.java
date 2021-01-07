package com.Egen.MovieBooking;

public class Movie {
	
	private String movieName;
	private static volatile Integer numberOfTickets;
	
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String movieName, Integer numberOfTickets) {
		super();
		this.movieName = movieName;
		this.numberOfTickets = numberOfTickets;
	}
	
	public synchronized boolean BookTickets(int num) {
		if (this.numberOfTickets <= num) {
			return false;
		} else {
			this.numberOfTickets = this.numberOfTickets - num;
			return true;
		}
	}
 
	public synchronized boolean CancelTickets(int num) {
			this.numberOfTickets = this.numberOfTickets + num;
			return true;

	}

	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(Integer numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

}
