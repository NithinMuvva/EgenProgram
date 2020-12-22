package oopsConcepts.FeetToCmConverter;

public class Helper {

	public static void main(String[] args) {
		// Creating new object
		FeetCentimeterConverter feetToCm = new FeetCentimeterConverter();

		//Input parameters
		double input1Double = 9.07;
		double input2Double = 8.15;
		double input3Double = 6.05;
		int input1Int = 16;
		int input2Int = 11;

		// Print Statements
		System.out.println("Value after converting " +  String.format("%.2f", input1Double) + " Feet to CentiMeters is " + String.format("%.3f", feetToCm.feetToCentimeter(input1Double)));
		System.out.println("Value after converting " + String.format("%.2f", input2Double) + " Feet " + String.format("%.2f", input3Double) + " Inches to CentiMeters is " + String.format("%.3f", feetToCm.feetToCentimeter(input2Double, input3Double)));
		System.out.println("Value after converting " + String.format("%d", input1Int) + " Feet " + String.format("%d", input2Int) + " Inches to CentiMeters is " + String.format("%d", feetToCm.feetToCentimeter(input1Int, input2Int)));
	}

}
