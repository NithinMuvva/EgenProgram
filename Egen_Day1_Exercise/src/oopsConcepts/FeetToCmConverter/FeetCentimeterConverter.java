package oopsConcepts.FeetToCmConverter;

public class FeetCentimeterConverter {

	// Constructor
	public FeetCentimeterConverter() {

	}

	// method accepts one argument of type double
	public double feetToCentimeter(double feet) {

		if (feet >= 0) {
			double cm = 30.48 * feet;
			return cm;
		} else {
			System.out.println("Please Enter the Valid Input");
		}
		return -1;

	}

	// overloading method accepts 2 argument of type double
	public double feetToCentimeter(double feet, double inches) {

		if (feet >= 0 && inches >= 0 && inches <= 12) {
			double inchestoFeet = inches / 12;
			double cm = 30.48 * (feet + inchestoFeet);
			return cm;
		} else {
			System.out.println("Please Enter the Valid Input");
		}
		return -1;
	}

	// overloading method accepts 2 argument of type int and returns int
	public int feetToCentimeter(int feet, int inches) {

		if (feet >= 0 && inches >= 0 && inches <= 12) {
			double inchestoFeet = inches / 12;
			double cm = 30.48 * (feet + inchestoFeet);
			return (int) cm;
		} else {
			System.out.println("Please Enter the Valid Input");
		}
		return -1;
	}

}
