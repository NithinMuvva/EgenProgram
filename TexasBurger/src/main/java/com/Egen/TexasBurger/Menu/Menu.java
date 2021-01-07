package com.Egen.TexasBurger.Menu;

import java.util.*;

import com.Egen.TexasBurger.Item;

public class Menu implements MenuInterface{
	
	private Map<String,List<Item>> categoryMap;
	private List<Item> Specials;
	
	public Menu() {		
		this.categoryMap = new HashMap<>();
		this.Specials = new ArrayList<>();
	}
	
	public Menu(Map<String, List<Item>> categoryMap, List<Item> specials) {		
		this.categoryMap = categoryMap;
		this.Specials = specials;
	}
	public Map<String, List<Item>> getCategory() {
		return categoryMap;
	}
	public void setCategoryMap(Map<String, List<Item>> categoryMap) {
		this.categoryMap = categoryMap;
	}
	public List<Item> getSpecials() {
		return Specials;
	}
	public void setSpecials(List<Item> specials) {
		Specials = specials;
	}
	
	public void addCategory(String category) {
		if(this.categoryMap != null && !this.categoryMap.containsKey(category)) {
			this.categoryMap.put(category, new ArrayList<Item>());
		}
	}
	
	public void removeCategory(String category) {
		if(this.categoryMap != null && !this.categoryMap.containsKey(category)) {
			this.categoryMap.remove(category);
		}
	}
	
	
	
	public void addItem(Item item, String category) {
		if(this.categoryMap != null && this.categoryMap.containsKey(category)) {
			this.categoryMap.get(category).add(item);
		}
	}


	
}
