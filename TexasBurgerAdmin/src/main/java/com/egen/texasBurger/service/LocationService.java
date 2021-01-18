package com.egen.texasBurger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.texasBurger.model.Location;
import com.egen.texasBurger.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	LocationRepository locRepo;
	
	public List<Location> getLocationByName(String name) throws Exception {
		 List<Location> optional  = locRepo.findByNameContaining(name);
		 if(!optional.isEmpty()){
	           return optional;
	        } else {
	            throw new Exception("Location with id not found");
	        }
	}
	
    public Location findByLocationsId(String id) throws Exception {
        Optional<Location> optional  = locRepo.findByLocationId(id);
        if(optional.isPresent()){
           return optional.get();
        } else {
            throw new Exception("Location with id not found");
        }
    }
    
    public List<Location> findAllLocation() throws Exception {
        List<Location> location  = locRepo.findAll();
        if(!location.isEmpty()){
           return location;
        } else {
            throw new Exception("Location with id not found");
        }
    }
    
    public void saveLocations(List<Location> location) {
    	location.forEach(loc->locRepo.save(loc));
    }
    
    public void saveLocation(Location location) {
    	locRepo.save(location);
    }
    
    public void deletAllLocation() {
    	locRepo.deleteAll();
    }
    public void deletLocationById(String id) throws Exception {
    	Optional<Location> location  = locRepo.findById(id);
        if(location.isPresent()){
        	locRepo.delete(location.get());
        } else {
            throw new Exception("Location with id not found");
        }
    }
    
    public Location updateLocation(String id, Location loc) throws Exception {
        Optional<Location> optional  = locRepo.findByLocationId(id);
        if(optional.isEmpty()){
            throw new Exception("Location with id "+id+" doesn't exist");
        }
        optional.ifPresent(location -> {
        	location.setName(loc.getName());
            location.setLongitude(loc.getLongitude());
            location.setLatitude(loc.getLatitude());
            location.setPhone(loc.getPhone());
            location.setAddress(loc.getAddress());
            locRepo.save(location);});
        return optional.get();
    }
    
    public Location findNearByLocation(Double Lat, Double Long) throws Exception {
        List<Location> location  = locRepo.findAll();
        Location res = null;
        if(!location.isEmpty()){
        	Double shortestDistance = Double.MAX_VALUE;
        	for(Location l : location) {
            	final int R = 6371; // Radius of the earth

                double latDistance = Math.toRadians(Lat - l.getLatitude());
                double lonDistance = Math.toRadians(Long - l.getLongitude());
                double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                        + Math.cos(Math.toRadians(Lat)) * Math.cos(Math.toRadians(l.getLatitude()))
                        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
                double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
                double distance = R * c * 1000; // convert to meters
                if(distance < shortestDistance) {
                    shortestDistance = distance;
                }
            }
        	return res;
        } else {
            throw new Exception("Location with id not found");
        }
    }
    
}
