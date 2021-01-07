package com.Egen.TexasBurger.Menu;

import java.util.List;
import java.util.Map;

import com.Egen.TexasBurger.Item;

public interface MenuInterface {

	Map<String, List<Item>> getCategory();
	List<Item> getSpecials();
	void addCategory(String category);
	void removeCategory(String category);
	void addItem(Item item, String category);
}
