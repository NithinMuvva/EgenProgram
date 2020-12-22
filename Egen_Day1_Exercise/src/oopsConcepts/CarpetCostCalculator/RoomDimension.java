package oopsConcepts.CarpetCostCalculator;

public class RoomDimension {

	private double lengthOfRoom;
	private double widthOfRoom;

	public RoomDimension(double length, double width) {
		this.lengthOfRoom = length;
		this.widthOfRoom = width;
	}
	public double getAreaOfRoom() {
		return lengthOfRoom * widthOfRoom;
	}

}
