package com.Egen.TexasBurger;

import java.util.List;
import java.util.Map;

public interface MenuInterface {

	Map<String, List<Item>> getCategory();
	List<Item> getSpecials();
	void addCategory(String category);
	void removeCategory(String category);
	void addSpecial(Item item);
	void removeSpecial(Item item);
	void addItem(Item item, String category);
}
