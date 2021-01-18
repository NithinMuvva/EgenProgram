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

import com.egen.texasBurger.model.Location;
import com.egen.texasBurger.model.Menu;
import com.egen.texasBurger.service.LocationService;
import com.egen.texasBurger.service.MenuService;

@RestController
@RequestMapping("/")
public class MenuController {

	@Autowired
	MenuService menuService;
	
	@GetMapping(value = "/menu")
    public ResponseEntity<?>  findAllMenu() {
        try {
            List<Menu> menu = menuService.findAllMenu();
            return new ResponseEntity<>(menu, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/menu")
    public ResponseEntity<?> saveMenu(@RequestBody List<Menu> menu) {
        try {
        	menuService.saveMenus(menu);
            return new ResponseEntity<>("Location is created sucessfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping(value = "/menu")
    public ResponseEntity<?> deleteAllMenu() {
        try {
        	menuService.deletAllMenu();
            return new ResponseEntity<>("Deleted sucessfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value = "/menu/{id}")
    public ResponseEntity<?>  getMenuById(@PathVariable("id") String id) {
        try {
        	Menu menu = menuService.findByMenuId(id);
            if (menu == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
            return new ResponseEntity<>(menu, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
    @PostMapping(value = "/menu/{id}")
    public ResponseEntity<?>  getMenuById(@RequestBody Menu menu) {
        try {
            menuService.savemenu(menu);
            return new ResponseEntity<>("Menu is Saved", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping(value = "/menu/{id}")
    public ResponseEntity<?>  updateLocationById(@PathVariable("id") String id,@RequestBody Menu menu) {
        try {
        	Menu updateMen = menuService.updateMenu(id, menu);
			return new ResponseEntity<>(updateMen, HttpStatus.OK);
            
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping(value = "/menu/{id}")
    public ResponseEntity<?>  updateLocationById(@PathVariable String id) {
        try {
        	menuService.deleteMenuById(id);
			return new ResponseEntity<>("Menu is deleted sucessfully", HttpStatus.OK);
            
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value = "/menu/menuType")
    public ResponseEntity<?> findByMenuType(@RequestParam String type){
        try{
            return new ResponseEntity<>(menuService.findByMenuType(type), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/menu/menuItem")
    public ResponseEntity<?> findByMenuItem(@RequestParam String name){
       try{
           return new ResponseEntity<>(menuService.findByMenuItem(name), HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       }
    }
    
    @PutMapping(value = "/menu/menuItem/{id}")
    public ResponseEntity<?> updateMenuItem(@PathVariable("id") String
                                                id, @RequestBody Menu menu){
        try {
            menuService.updateMenu(id, menu);
            return new ResponseEntity<>("Updated menu item with id: "+id,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value="/menuItem/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable("id") String id){
        try {
            menuService.deleteMenuById(id);
            return new ResponseEntity<>("Deleted item with id: "+id,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
