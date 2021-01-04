package com.Egen.TexasBurger;

import java.util.List;
import java.util.Map;

public class Restuarant implements TexasBurgerInterface{
	
	private Menu menu;
	private Location location;
	private Integer phone;
	private String Timings;
	private Cart cart;
	
	public Restuarant(Menu menu, Location location) {
		this.menu = menu;
		this.location = location;
	}
	
	public Restuarant() {
		
	}

	public Menu getMenu() {
		
        for(Map.Entry<String, List<Item>> entry : menu.getCategory().entrySet()) {
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
	
}
