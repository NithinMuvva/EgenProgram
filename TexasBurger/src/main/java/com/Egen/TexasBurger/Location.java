package com.Egen.TexasBurger;

public class Location {
	
	@Override
	public String toString() {
		return "Location [street=" + street + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zipcode=" + zipcode + ", phone=" + phone + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", restuarant=" + restuarant + "]";
	}
	private String street;
	private String city;
	private String state;
	private String country;
	private int zipcode;
	private long phone;
	private double latitude;
	private double longitude;
	private Restuarant restuarant;
	
	
	public Restuarant getRestuarant() {
		return restuarant;
	}

	public void setRestuarant(Restuarant restuarant) {
		this.restuarant = restuarant;
	}

	public Location(String street, String state, String city, String country, int zipcode, int phone, double latitude,
			double longitude) {
		this.street = street;
		this.state = state;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.phone = phone;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	

}
