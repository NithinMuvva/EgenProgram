package com.Egen.TexasBurger.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Egen.TexasBurger.Item;

public class SpecialMenu implements MenuInterface{

	private List<Item> specials ;
	
	public SpecialMenu() {
		this.specials = new ArrayList<Item>();
	}

	@Override
	public Map<String, List<Item>> getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCategory(String category) {
		// TODO Auto-generated method stub
		this.specials = new ArrayList<Item>();
		
	}


	@Override
	public void addItem(Item item, String category) {
		// TODO Auto-generated method stub
		this.specials.add(item);
	}

	@Override
	public List<Item> getSpecials() {
		// TODO Auto-generated method stub
		return this.specials;
	}
	
	public void setSpecials(List<Item> spl) {
		// TODO Auto-generated method stub
		this.specials = spl;
	}

	@Override
	public void removeCategory(String category) {
		// TODO Auto-generated method stub
		
	}
}
