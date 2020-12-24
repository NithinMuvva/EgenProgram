package oopsConcepts.CarpetCostCalculator;

import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class CarpetCostCalculator {

	static HashMap<String,String> countryMap = new HashMap<>();
	static HashMap<String,Double> priceMap = new HashMap<>();
	static HashMap<String,Double> currencyMap = new HashMap<>();

	public CarpetCostCalculator() {

	}
	
	private static Logger logger = Logger.getLogger(CarpetCostCalculator.class);

	public static void main(String[] args) {

		
		RoomCarpet roomCarpet = null;
		Scanner sc = new Scanner(System.in);
		countryMap.put("USA","Foot");
		countryMap.put("IND","Centimeters");
		countryMap.put("UK","Feet");
		countryMap.put("Aus","Meter");

		priceMap.put("white",10.6);
		priceMap.put("blue",38.6);
		priceMap.put("red",51.0);
		priceMap.put("green",70.0);

		currencyMap.put("INR",75.0);
		currencyMap.put("EUR",0.9);
		currencyMap.put("AD",1.2);

		try {

			logger.info("Please enter the country[USA,IND,UK,AUS]");
			String country = sc.next();
			String unit = countryMap.get(country);

			logger.info("Please enter the dimensions of the room and the price per square foot of the carpet");
			logger.info("Enter the length of the room in " + unit + ": ");
			double lengthOfRoom = sc.nextDouble();

			logger.info("Enter the width of the room in " + unit + ": ");
			double widthOfRoom = sc.nextDouble();

			logger.info("Enter the type of the carpet : ");
			String type = sc.next();
			RoomCarpetType carpetType = new RoomCarpetType();
			carpetType.setPriceMap(priceMap);
			
			logger.debug(carpetType.getPrice(type));
			roomCarpet = new RoomCarpet(lengthOfRoom, widthOfRoom, carpetType.getPrice(type));

			logger.info("Total Cost of the Carpet is $" + String.format("%.2f", roomCarpet.getTotalCost()));

			logger.info("Please select currency to convert the cost [USD,INR,EUR,AD] : ");
			String currency = sc.next();

			CurrencyConverter converter = new CurrencyConverter(currency);
			converter.setCurrencyMap(currencyMap);
			logger.info("Total Cost of the Carpet in "+ currency + " "+ String.format("%.2f", converter.totalCurreny(roomCarpet.getTotalCost())));

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
