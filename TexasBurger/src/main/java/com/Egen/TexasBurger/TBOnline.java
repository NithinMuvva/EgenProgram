package com.Egen.TexasBurger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class TBOnline {

	private static Logger logger = Logger.getLogger(TBOnline.class);
	private Restuarant nearRes;
	
	private  List<Restuarant> resList;
	
	private  List<Location> locatList;
	
    private static Scanner sc = new Scanner(System.in);
	
	public  void intialize() {
		
		Location boston = new Location("123 street", "MA", "USA", 50303, 894982021, 12.3, 16.4);
		Location chicago = new Location("345 street", "IL", "USA", 50303, 894982021, 15.3, 16.4);
		Location newyork = new Location("456 street", "NY", "USA", 50303, 894982021, 18.3, 16.4);
		
		Menu menu = new Menu();
		// Category - Sandwiches
        List<Item> starterList = new ArrayList<>();
        starterList.add(new Item("Chicken Bites", 5.99));
        starterList.add(new Item("Fried Chicken", 6.99));
        starterList.add(new Item("Veg Bites", 3.99));
        menu.addCategory("Starters");
        menu.getCategory().get("Starters").addAll(starterList);
        
        
        List<Item> burgerList = new ArrayList<>();
        burgerList.add(new Item("Chicken Texas Burger", 5.99));
        burgerList.add(new Item(" Veg Texas Burger", 6.99));
        burgerList.add(new Item("Fish Texas Burger", 7.99));
        menu.addCategory("Burgers");
        menu.getCategory().get("Burgers").addAll(starterList);

        List<Item> comboList = new ArrayList<>();
        comboList.add(new Item("VegBurger-Coke-Fries", 11.99,"Combo"));
        comboList.add(new Item("ChickenBurger-Coke-Fries", 12.99,"Combo"));;
        comboList.add(new Item("FishBurger-Coke-Fries", 13.99,"Combo"));
        menu.addCategory("Combos");
        menu.getCategory().get("Combos").addAll(starterList);
        
        List<Item> specialityList = new ArrayList<>();
        specialityList.add(new Item("Fries", 7.99));
        specialityList.add(new Item("Chef special", 11.99));
        menu.addCategory("Specialities");
        menu.getCategory().get("Specialities").addAll(starterList);
        
        Restuarant  chicRest = new Restuarant(menu, chicago);
        chicago.setRestuarant(chicRest);
        Restuarant  bosRest = new Restuarant(menu,  boston);
        boston.setRestuarant(bosRest);
        Restuarant  nyRest = new Restuarant(menu, newyork);
        newyork.setRestuarant(nyRest);
        
        this.resList.add(chicRest);
        this.resList.add(bosRest);
        this.resList.add(nyRest);
        this.locatList.add(boston);
		this.locatList.add(chicago);
		this.locatList.add(newyork);
        
	}
	
	public String searchClosestLocation() {

        System.out.println("Please provide your current location's latitude: ");
        Double currLatitude = Double.parseDouble(sc.nextLine());
        System.out.println("Please provide your current location's longitude: ");
        Double currLongitude = Double.parseDouble(sc.nextLine());
        Double shortestDistance = Double.MAX_VALUE;
        for(Location l : this.locatList) {
        	final int R = 6371; // Radius of the earth

            double latDistance = Math.toRadians(currLatitude - l.getLatitude());
            double lonDistance = Math.toRadians(currLongitude - l.getLongitude());
            double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                    + Math.cos(Math.toRadians(currLatitude)) * Math.cos(Math.toRadians(l.getLatitude()))
                    * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = R * c * 1000; // convert to meters
            if(distance < shortestDistance) {
                shortestDistance = distance;
                this.nearRes = l.getRestuarant();
            }
        }
        System.out.println(" Nearest location is " + this.nearRes.getLocation());
        return this.nearRes.getLocation().toString();
    }
	
	
	
	public TBOnline() {
		// TODO Auto-generated constructor stub
		this.locatList = new ArrayList<Location>();
		this.resList = new ArrayList<>();
		this.nearRes = null;
		
	}

	
	public static void main(String[] args) {
		
		try {
			
			 System.out.println("Welcome to Texas Burger Online Delivery Platform");
			 System.out.println("Please enter the location details below ");
			
			TBOnline tb = new TBOnline();
			tb.intialize();
			tb.searchClosestLocation();
			if(tb.nearRes != null) {
				tb.nearRes.getMenu();
			}
			System.out.println("Please enter to view the cart [y] [n]");
			String input = sc.nextLine();
			Item i = new Item("Fries", 7.99);
			tb.nearRes.addToCart(i, 2);
			if(input.toLowerCase().equals("y")) {
				tb.nearRes.viewCart();
			}

			logger.info("Thank you");
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("Please enter the valid input type ");
			logger.error(e.getMessage().toString());
		}
		finally {
			sc.close();
		}

	}
}
