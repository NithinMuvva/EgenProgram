package oopsConcepts.CarpetCostCalculator;

// Using Inheritance to use methods on super class
public class RoomCarpet extends RoomDimension{
	
	private double costOfCarpet;
	
	public RoomCarpet(double length, double width, double cost) {
		super(length,width);
	    this.costOfCarpet = cost;
	}
	public double getTotalCost() {
	    return costOfCarpet * this.getAreaOfRoom();
	}
}
