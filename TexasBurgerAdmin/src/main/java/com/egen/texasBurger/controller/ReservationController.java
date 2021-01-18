package com.egen.texasBurger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egen.texasBurger.model.Reservation;
import com.egen.texasBurger.service.ReservationService;

@RestController
@RequestMapping(value = "/")
public class ReservationController {

	@Autowired
    ReservationService resService;
	
	@GetMapping("/reservations")
    public ResponseEntity<?> getAllReservations(){
        try{
            return new ResponseEntity<>(resService.findAllReservations(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/reservations/fullName/")
    public ResponseEntity<?> getAllReservationByType(@RequestParam String fullname){
        try{
            return new ResponseEntity<>(resService.findByFullName(fullname), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PostMapping("/reservations")
    public  ResponseEntity<?> saveAllReservations(@RequestBody List<Reservation> reservations){
        try{
        	resService.saveReservation(reservations);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@DeleteMapping("reservations")
    public ResponseEntity<?> deleteAllReservations(){
        try{
        	resService.deleteAllReservations();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/reservations/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable("id") String id ){
        try{
            return new ResponseEntity<>(resService.findById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping("/reservations/{id}")
    public  ResponseEntity<?> updateReservation(@PathVariable("id") String id, @RequestBody Reservation reservation) {
        try{
        	resService.updateReservation(id, reservation);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("reservations/{id}")
    public ResponseEntity<?> deleteReservationById(@PathVariable("id") String id){
        try{
            resService.deleteReservation(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
	
}
