package com.egen.texasBurger.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.texasBurger.model.Reservation;
import com.egen.texasBurger.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
    ReservationRepository reservationRepository;
	public Reservation findByFullName(String fullName) throws Exception {
        Optional<Reservation> reservation = reservationRepository.findByFullName(fullName);
        if (reservation.isPresent()) {
            return reservation.get();
        } else {
            throw new Exception("Reservation with Full Name" + fullName + " not found");
        }
    }
	
	public Reservation findByEmail(String email) throws Exception {
        Optional<Reservation> reservation = reservationRepository.findByEmail(email);
        if (reservation.isPresent()) {
            return reservation.get();
        } else {
            throw new Exception("Reservation with Email" + email + " not found");
        }
    }
	
	public Reservation findById(String id) throws Exception {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            return reservation.get();
        } else {
            throw new Exception("Reservation with Email" + id + " not found");
        }
    }
	
	public Reservation findByDate(Date date) throws Exception {
        Optional<Reservation> reservation = reservationRepository.findByDateOfEvent(date);
        if (reservation.isPresent()) {
            return reservation.get();
        } else {
            throw new Exception("Reservation with date: " + date + " doesn't exist");
        }
    }
	
	public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }
	
	public Reservation saveReservation(List<Reservation> reservations){
        List<Reservation> allReservations = reservationRepository.findAll();
        reservations.forEach(reservation -> {
                    if (reservation.getDateOfEvent().before(new Date())) {
                        return;
                    }
                    for (Reservation reserve : allReservations) {
                        if (reserve.getDateOfEvent().equals(reservation.getDateOfEvent())) {
                            return;
                        }
                    }
                    reservationRepository.save(reservation);
                    allReservations.add(reservation);
                }
        );
		return null;
    }
	
	public void updateReservation(String id, Reservation reservation) throws Exception {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isEmpty()) {
            throw new Exception("Reservation with id: " + id + " doesn't exist");
        }
        Date currentDate = new Date();
        if (reservation.getDateOfEvent().before(currentDate)) {
            return;
        }
        List<Reservation> allReservations = reservationRepository.findAll();
        for (Reservation reserve : allReservations) {
            if (reserve.getDateOfEvent().equals(reservation.getDateOfEvent())) {
               return ;
            }
        }
        reservationOptional.ifPresent(reservations -> {
            reservations.setContact(reservation.getContact());
            reservations.setDateOfBooking(reservation.getDateOfBooking());
            reservations.setFullName(reservation.getFullName());
            reservations.setDateOfEvent(reservation.getDateOfEvent());
            reservations.setEventCategory(reservation.getEventCategory());
            reservationRepository.save(reservations);
        });
    }
	
	 public void deleteReservation(String id) throws Exception {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            reservationRepository.deleteById(id);
        } else {
            throw new Exception("Reservation with id: " + id + " doesn't exist");
        }
    }
	 
	public void deleteAllReservations() {
        reservationRepository.deleteAll();
    }
	

}
