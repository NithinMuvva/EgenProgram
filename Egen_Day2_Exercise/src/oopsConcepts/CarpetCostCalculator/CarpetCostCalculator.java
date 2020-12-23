package oopsConcepts.CarpetCostCalculator;

import java.util.HashMap;
import java.util.Scanner;

public class CarpetCostCalculator {

	static HashMap<String,String> countryMap = new HashMap<>();
	static HashMap<String,Double> priceMap = new HashMap<>();
	static HashMap<String,Double> currencyMap = new HashMap<>();

	public CarpetCostCalculator() {

	}

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

			System.out.println("Please enter the country[USA,IND,UK,AUS]");
			String country = sc.next();
			String unit = countryMap.get(country);

			System.out.println("Please enter the dimensions of the room and the price per square foot of the carpet");
			System.out.print("Enter the length of the room in " + unit + ": ");
			double lengthOfRoom = sc.nextDouble();

			System.out.print("Enter the width of the room in " + unit + ": ");
			double widthOfRoom = sc.nextDouble();

			System.out.print("Enter the type of the carpet : ");
			String type = sc.next();
			RoomCarpetType carpetType = new RoomCarpetType();
			carpetType.setPriceMap(priceMap);
			roomCarpet = new RoomCarpet(lengthOfRoom, widthOfRoom, carpetType.getPrice(type));

			System.out.println("Total Cost of the Carpet is $" + String.format("%.2f", roomCarpet.getTotalCost()));

			System.out.print("Please select currency to convert the cost [USD,INR,EUR,AD] : ");
			String currency = sc.next();

			CurrencyConverter converter = new CurrencyConverter(currency);
			converter.setCurrencyMap(currencyMap);
			System.out.println("Total Cost of the Carpet in "+ currency + " "+ String.format("%.2f", converter.totalCurreny(roomCarpet.getTotalCost())));

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Please enter the valid input type ");
			System.out.println(e.getMessage().toString());
		}
		finally {
			sc.close();
		}




	}

}
