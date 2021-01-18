package com.egen.texasBurger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.egen.texasBurger.model.Reservation;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {

    Optional<Reservation> findByFullName(String fullName);
    Optional<Reservation> findByEmail(String email);
    Optional<Reservation> findByDateOfEvent(Date dateOfEvent);
}
