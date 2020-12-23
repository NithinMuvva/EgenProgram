package oopsConcepts.CarpetCostCalculator;

import java.util.Map;

public class RoomCarpetType {
	
	private Map<String,Double> priceMap = null;


	public RoomCarpetType() {
		// TODO Auto-generated constructor stub
	}
	

	public RoomCarpetType(Map<String,Double> priceMap) {
		this.priceMap = priceMap;
	}
	
	
	
	public Double getPrice(String type) {
		
		if(priceMap != null && priceMap.containsKey(type)) {
			return priceMap.get(type);
		}
		
		return null;
	}

	
	public Map<String, Double> getPriceMap() {
		return priceMap;
	}

	public void setPriceMap(Map<String, Double> priceMap) {
		this.priceMap = priceMap;
	}


}
