package com.Egen.MovieBooking;

import java.util.concurrent.locks.ReentrantLock;

public class MovieWithLock {
	
	private String movieName;
	private Integer numberOfTickets;

	ReentrantLock lock = new ReentrantLock();
	
	public MovieWithLock() {
		// TODO Auto-generated constructor stub
	}
	
	public MovieWithLock(String movieName, Integer numberOfTickets) {
		super();
		this.movieName = movieName;
		this.numberOfTickets = numberOfTickets;
	}
	
	public  void BookTickets(int num) {
		lock.lock();
		try {
			if (this.numberOfTickets <= num) {
			} else {
				this.numberOfTickets = this.numberOfTickets - num;
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			lock.unlock();
			
		}
	}
 
	public synchronized void CancelTickets(int num) {
		lock.lock();
		try {
			this.numberOfTickets = this.numberOfTickets + num;
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			lock.unlock();
			
		}

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
