package com.egen.texasBurger.controller;

import java.util.ArrayList;
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

import com.egen.texasBurger.model.Location;
import com.egen.texasBurger.service.LocationService;

@RestController
@RequestMapping("/")
public class LocationController {

	@Autowired
	LocationService locService;
	
	@GetMapping("/location/byname/{name}")
	public ResponseEntity<List<Location>> searchLocationByName(@PathVariable("name") String name){
		
		try {
			List<Location> location = new ArrayList<>();
			if(name != null) {
				location = locService.getLocationByName(name);
			}else {
				locService.findAllLocation().forEach(location::add);
			}

			if (location.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(location, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/location")
    public ResponseEntity<?>  findAllLocations() {
        try {
            List<Location> locations = locService.findAllLocation();
            return new ResponseEntity<>(locations, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/location")
    public ResponseEntity<?> saveLocations(@RequestBody List<Location> location) {
        try {
        	locService.saveLocations(location);
            return new ResponseEntity<>("Location is created sucessfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping(value = "/location")
    public ResponseEntity<?> deleteAllLocations() {
        try {
        	locService.deletAllLocation();
            return new ResponseEntity<>("Deleted sucessfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value = "/location/{id}")
    public ResponseEntity<?>  getLocationById(@PathVariable("id") String id) {
        try {
            Location location = locService.findByLocationsId(id);
            if (location == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
            return new ResponseEntity<>(location, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
    @PostMapping(value = "/location/{id}")
    public ResponseEntity<?>  getLocationById(@RequestBody Location location) {
        try {
            locService.saveLocation(location);
            return new ResponseEntity<>("Location is Saved", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping(value = "/location/{id}")
    public ResponseEntity<?>  updateLocationById(@PathVariable("id") String id,@RequestBody Location location) {
        try {
        	Location updateLoc = locService.updateLocation(id, location);
			return new ResponseEntity<>(updateLoc, HttpStatus.OK);
            
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping(value = "/location/{id}")
    public ResponseEntity<?>  updateLocationById(@PathVariable String id) {
        try {
        	locService.deletLocationById(id);
			return new ResponseEntity<>("Location is deleted sucessfully", HttpStatus.OK);
            
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/location/nearby/")
    public ResponseEntity<?> searchNearByLocation(@RequestParam(name = "longitude") Double longitude, @RequestParam(name = "latitude") Double latitude) { 
    	try {
        	Location loc = locService.findNearByLocation(latitude, longitude);
			return new ResponseEntity<>(loc, HttpStatus.OK);
            
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
