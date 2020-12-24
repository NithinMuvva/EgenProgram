package oopsConcepts.CarpetCostCalculator;

import java.util.Map;

public class CurrencyConverter {


	private Map<String,Double> currencyMap = null;
	private String country;
	// Constructor
	public CurrencyConverter(String country) {
		this.country = country;
	}

	public Map<String, Double> getCurrencyMap() {
		return currencyMap;
	}

	public void setCurrencyMap(Map<String, Double> currencyMap) {
		this.currencyMap = currencyMap;
	}

	// overloading method accepts 1 argument of type double
	public double totalCurreny (double usd) {
		return usd*this.currencyMap.get(this.country);
	}

	// overloading method accepts 2 argument of type double
	public double totalCurreny (double usd, double currency) {
		return usd * currency;
	}

}
