package com.Egen.MovieBooking;


public class BookingWithLock extends Thread {
	
	public static enum BookingType {
		BOOK_TICKET(1), CANCEL_TICKET(2);
 
		private BookingType(int value) {
		}
	};
 
	private BookingType bookingType;
	private MovieWithLock movieLock;
	private int number;
	
	public BookingWithLock(MovieWithLock movie, BookingType bookingType, int number) {
		this.bookingType = bookingType;
		this.movieLock = movie;
		this.number = number;
	}
 
	public void run() {
		switch (this.bookingType) {
		case BOOK_TICKET:
			bookTicket();
			printTickets();
			break;
		case CANCEL_TICKET:
			cancelTicket();
			printTickets();
			break;
		default:
			System.out.println("NOT A VALID TRANSACTION");
		}
	}
 
	public  void bookTicket() {
		this.movieLock.BookTickets(this.number);
	}
 
	public  void cancelTicket() {
		this.movieLock.CancelTickets(this.number);
	}
 
	public  void printTickets() {
		System.out.println(Thread.currentThread().getName() + " : bookingType: " + this.bookingType +  " : movieName: " + this.movieLock.getMovieName() +", Amount: " + this.number);
	}

}
