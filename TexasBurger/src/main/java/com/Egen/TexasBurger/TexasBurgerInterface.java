package com.Egen.TexasBurger;

import java.util.List;

import com.Egen.TexasBurger.Menu.Menu;

public interface TexasBurgerInterface {

	Menu getMenu();
    Cart viewCart();
	void addToCart(Item item, int count);
	Location getLocation();
	List<Reservations> getReservations();
	void addReservation(Reservations res);
}
