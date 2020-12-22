package oopsConcepts.CarpetCostCalculator;

import java.util.Scanner;

public class CarpetCostCalculator {
	

	public CarpetCostCalculator() {
		
	}
	
	public static void main(String[] args) {
		
		RoomCarpet roomCarpet = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			
	        System.out.println("Please enter the dimensions of the room and the price per square foot of the carpet");
	        System.out.print("Enter the length of the room: ");
	        double lengthOfRoom = sc.nextDouble();

	        System.out.print("Enter the width of the room: ");
	        double widthOfRoom = sc.nextDouble();

	        System.out.print("Enter the price per square foot of the carpet : ");
	        double costOfCarpet = sc.nextDouble();
	        
	        roomCarpet = new RoomCarpet(lengthOfRoom, widthOfRoom, costOfCarpet);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Please enter the valid input type ");
			System.out.println(e.getMessage().toString());
		}
		finally {
			sc.close();
		}

        System.out.println("Total Cost of the Carpet is " + String.format("%.2f", roomCarpet.getTotalCost()));
		
		
	}
	
}
