package com.Egen.TexasBurger;

public interface TexasBurgerInterface {

	Menu getMenu();
    Cart viewCart();
	void addToCart(Item item, int count);
	Location getLocation();
}
