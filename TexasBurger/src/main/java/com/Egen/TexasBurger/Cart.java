package com.Egen.TexasBurger;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<Item,Integer> items;
	private Double totalPrice;
	
	public Cart() {
		this.items = new HashMap<>();
		this.totalPrice = 0.0;
	}
	
	public Map<Item,Integer> addToCart (int count,Item item){
		this.items.put(item, count);
		return this.items;
		
	}
	
	public Map<Item, Integer> getItems() {
		return items;
	}

	public void setItems(Map<Item, Integer> items) {
		this.items = items;
	}

	public double getItemsPrice() {	
		for(Item i : this.items.keySet()) {
			this.totalPrice = this.totalPrice + i.getPrice();
		}
		return this.totalPrice;
	}
	
	public double applyCoupon(Double disc) {
		Double discount = this.getItemsPrice() * disc /100;
		return this.getItemsPrice() - discount;
	}
	
	public double calculateTax(Double tax) {
		return this.getItemsPrice()*tax/100;
	}
	
	public double getTotalPrice() {	
		 this.getItemsPrice();
		 this.applyCoupon(10.0);
		 return this.totalPrice + this.calculateTax(12.12);
		
	}
	
	
	
	
	
}
