package com.Egen.TexasBurger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.Egen.TexasBurger.Menu.Menu;

public class TBOnline {

	private static Logger logger = Logger.getLogger(TBOnline.class);
	private Restuarant nearRes;
	
	private  List<Restuarant> resList;
	
	private  List<Location> locatList;
	
	private  List<Item> splList;
	
	
	private DataReader dataReader;
	
    private static Scanner sc = new Scanner(System.in);
	
	public  void intialize() throws FileNotFoundException, IOException, ParseException {
        this.resList = dataReader.getResList();
        this.locatList = dataReader.getLocationsList();
        this.splList = dataReader.getSpecialList();
	}
	
	public void addLocation() {
		logger.info("Enter Street: ");
		String street = sc.nextLine();
		logger.info("Enter City: ");
		String city = sc.nextLine();
		logger.info("Enter State: ");
		String country = sc.nextLine();
		logger.info("Please provide your location's latitude: ");
        Double currLatitude = Double.parseDouble(sc.nextLine());
        logger.info("Please provide your location's longitude: ");
        Double currLongitude = Double.parseDouble(sc.nextLine());
        logger.info("Enter Phone: ");
		Integer phone = sc.nextInt();
		logger.info("Enter ZipCode: ");
		String zipCode = sc.next();
		String state = sc.nextLine();
		logger.info("Enter Country: ");
		
        Location l = new Location(street, state, city, country, Integer.parseInt(zipCode), phone, currLatitude, currLongitude);
		this.locatList.add(l);
	}
	
	
	public String searchClosestLocation() {

		logger.info("Please provide your current location's latitude: ");
        Double currLatitude = Double.parseDouble(sc.nextLine());
        logger.info("Please provide your current location's longitude: ");
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
	
	
	
	public TBOnline() throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated constructor stub
		this.locatList = new ArrayList<Location>();
		this.resList = new ArrayList<>();
		this.splList = new ArrayList<>();
		this.nearRes = null;
		this.dataReader = new DataReader();
		
	}

	
	public static void main(String[] args) {
		
		try {

			System.out.println("Welcome to Texas Burger Online Delivery Platform");
			TBOnline tb = new TBOnline();
			tb.intialize();
			while (true) {
				System.out.println("Please select from below options\n" + "1. Locations\n" + "2. Menu\n" + "3. Exit");
				Integer choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					System.out.println(
							"Please select from below options\n" + "1. View Locations\n" + "2. Add Location\n");
					Integer lchoice = Integer.parseInt(sc.nextLine());
					if (lchoice == 1) {
						System.out.println("-------------------------------");
						int index = 0;
						for (Location l : tb.locatList) {
							index++;
							logger.info(index + "----" + l);
						}
						System.out.println("-------------------------------");
						System.out.println();
					} else {
						tb.addLocation();
						logger.info("Location Sucessfylly Added");
					}
					break;
				case 2:
					System.out.println("Please enter the location details below ");
					tb.searchClosestLocation();
					if (tb.nearRes != null) {
						tb.nearRes.getMenu();
					}
					
					System.out.println(
							"Please select from below options\n" + "1. View Reservations\n" + "2. Make Reservation\n");
					Integer reschoice = Integer.parseInt(sc.nextLine());
					if (reschoice == 1) {
						System.out.println("-------------------------------");
						int index = 0;
						for (Reservations r : tb.nearRes.getReservations()) {
							index++;
							logger.info(index + "----" + r);
						}
						System.out.println("-------------------------------");
						System.out.println();
					} else {
						System.out.println("Please Reservation details below ");
						logger.info("Please provide customer name: ");
						String cName = sc.nextLine();
						logger.info("Please provide date of reservation: ");
						Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
						Reservations r = new Reservations(cName, date);
						tb.nearRes.addReservation(r);
						logger.info("Reservation Sucessfylly Added");
					}
					break;
					
				case 4:
					System.out.println("Exiting Application");
					tb.dataReader.setCategoryMap(tb.resList.get(0).getMenu().getCategory());
					tb.dataReader.setLocationsList(tb.locatList);
					tb.dataReader.setResList(tb.resList);
					tb.dataReader.setSpecialList(tb.splList);
					tb.dataReader.DataWriter();
					
					Item i = new Item("Fries", 7.99);
					tb.nearRes.addToCart(i, 2);
					tb.nearRes.viewCart();

					logger.info("Thank you");
					
					System.exit(0);
				default:
					System.out.println("Please provide an option to continue");
					break;
				}
			}
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
