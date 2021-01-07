package com.Egen.MovieBooking;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class RaceCondition {

	public static void main(String[] args) {
		Movie movie = new Movie("Interstellar",100);
		
		// 10 tickets
		synchronized (movie) {
			Thread th = new Thread(new Booking(movie, Booking.BookingType.BOOK_TICKET, 10));
			th.start();
		}
		
		// Total Expected :  (10 x 2)
		for (int i = 0; i < 10; i++) {
			Booking t = new Booking(movie, Booking.BookingType.BOOK_TICKET, 2);
			t.start();
		}
 
		// Total Expected :  (10 x 1)
		for (int i = 0; i < 10; i++) {
			Booking t = new Booking(movie, Booking.BookingType.CANCEL_TICKET, 1);
			t.start();
 
		}
 
		// Let's just wait for a second to make sure all thread execution completes.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);
			Thread.currentThread().interrupt(); // restore the interrupted state
		}
 
		// Expected account balance is 80
		System.out.println("Final Account Balance: " + movie.getNumberOfTickets());
		
		MovieWithLock mv = new MovieWithLock("InfinityWAr",50);
		Executor exe = Executors.newFixedThreadPool(5);
		// Total Expected :  (10 x 2)
		for (int i = 0; i < 10; i++) {
			BookingWithLock t = new BookingWithLock(mv, BookingWithLock.BookingType.BOOK_TICKET, 2);
			exe.execute(t);
		}
		
		System.out.println("Final Account Balance: " + mv.getNumberOfTickets());
	}
}
