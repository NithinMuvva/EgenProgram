package com.egen.texasBurger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.texasBurger.model.Location;
import com.egen.texasBurger.model.Menu;
import com.egen.texasBurger.repository.LocationRepository;
import com.egen.texasBurger.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	MenuRepository menuRepo;
	
	/*
	 * public List<Location> getLocationByName(String name) throws Exception {
	 * List<Location> optional = menuRepo.findByNameContaining(name);
	 * if(!optional.isEmpty()){ return optional; } else { throw new
	 * Exception("Location with id not found"); } }
	 */
	
    public Menu findByMenuId(String id) throws Exception {
        Optional<Menu> optional  = menuRepo.findById(id);
        if(optional.isPresent()){
           return optional.get();
        } else {
            throw new Exception("Menu with id not found");
        }
    }
    
    public List<Menu> findAllMenu() throws Exception {
        List<Menu> menu  = menuRepo.findAll();
        if(!menu.isEmpty()){
           return menu;
        } else {
            throw new Exception("Location with id not found");
        }
    }
    
    public void saveMenus(List<Menu> menu) {
    	menu.forEach(m->menuRepo.save(m));
    }
    
    public void savemenu(Menu menu) {
    	menuRepo.save(menu);
    }
    
    public void deletAllMenu() {
    	menuRepo.deleteAll();
    }
    public void deleteMenuById(String id) throws Exception {
    	Optional<Menu> menu  = menuRepo.findById(id);
        if(menu.isPresent()){
        	menuRepo.delete(menu.get());
        } else {
            throw new Exception("Menu with id not found");
        }
    }
    
    public Menu updateMenu(String id, Menu menu) throws Exception {
        Optional<Menu> optional  = menuRepo.findById(id);
        if(optional.isEmpty()){
            throw new Exception("Location with id "+id+" doesn't exist");
        }
        optional.ifPresent(m -> {
        	m.setCategory(menu.getCategory());
        	m.setItem(menu.getItem());
        	m.setMtype(menu.getMtype());
        	m.setPrice(menu.getPrice());
            menuRepo.save(m);});
        return optional.get();
    }
    
    public List<Menu> findByMenuType(String type) throws Exception {
        List<Menu> menu = menuRepo.findByMtype(type);
        if (menu.isEmpty()) {
            throw new Exception("Menu type " + type + " not found");
        } else {
            return menu;
        }
    }
    
    public Menu findByMenuItem(String itemName) throws Exception {
        Optional<Menu> menu = Optional.ofNullable(menuRepo.findByItem(itemName));
        if (menu.isEmpty()) {
            throw new Exception("Menu item  " + itemName + " not found");
        } else {
            return menu.get();
        }
    }
    
}
