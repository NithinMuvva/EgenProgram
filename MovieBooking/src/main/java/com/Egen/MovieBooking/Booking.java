package com.Egen.MovieBooking;


public class Booking extends Thread {
	
	public static enum BookingType {
		BOOK_TICKET(1), CANCEL_TICKET(2);
 
		private BookingType(int value) {
		}
	};
 
	private BookingType bookingType;
	private Movie movie;
	private int number;
	
	public Booking(Movie movie, BookingType bookingType, int number) {
		this.bookingType = bookingType;
		this.movie = movie;
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
		this.movie.BookTickets(this.number);
	}
 
	public  void cancelTicket() {
		this.movie.CancelTickets(this.number);
	}
 
	public  void printTickets() {
		System.out.println(Thread.currentThread().getName() + " : bookingType: " + this.bookingType + ", Amount: " + this.number);
	}

}
