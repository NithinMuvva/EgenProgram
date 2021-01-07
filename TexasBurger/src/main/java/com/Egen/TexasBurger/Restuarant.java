package com.Egen.TexasBurger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Egen.TexasBurger.Menu.Menu;


public class Restuarant implements TexasBurgerInterface{
	
	private Menu menu;
	private Location location;
	private Integer phone;
	private String Timings;
	private Cart cart;
	private List<Reservations> reservations;
	
	public Restuarant(Menu menu, Location location) {
		this.menu = menu;
		this.location = location;
		this.reservations = new ArrayList<>();
	}
	
	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}

	public Restuarant() {
		
	}

	public Menu getMenu() {
		
        for(Map.Entry<String, List<Item>> entry :this.menu.getCategory().entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("-------------------------------");
            int index = 0;
            for (Item item: entry.getValue()) {
                index++;
                System.out.println(String.format("%s %s : $%s",index ,item.getName(), item.getPrice()));
            }
            System.out.println("-------------------------------");
            System.out.println();
        }
		return menu;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Integer getPhone() {
		return phone;
	}
	
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	public String getTimings() {
		return Timings;
	}

	public void setTimings(String timings) {
		Timings = timings;
	}

	@Override
	public void addToCart(Item item, int count) {
		// TODO Auto-generated method stub
		if(this.cart == null) {
			this.cart = new Cart();
		}
		this.cart.addToCart(count, item);
		
	}

	@Override
	public Cart viewCart() {
		// TODO Auto-generated method stub
        for(Map.Entry<Item, Integer> entry : this.cart.getItems().entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("-------------------------------");
            int index = 0;
            index++;
            System.out.println(String.format("%s %s : $%s",index ,entry.getKey().getName(), entry.getValue()));
            System.out.println("-------------------------------");
            System.out.println();
        }
		return cart;
	}
	
	@Override
	public void addReservation(Reservations res) {
		// TODO Auto-generated method stub
		this.reservations.add(res);
		
	}

	@Override
	public List<Reservations> getReservations() {
		// TODO Auto-generated method stub
		return this.reservations;
	}
	
}
