package com.Egen.TexasBurger;

import java.util.Date;

public class Reservations {

	@Override
	public String toString() {
		return "Reservations [customerName=" + customerName + ", date=" + date + "]";
	}

	private String customerName;
	private Date date;
	
	public Reservations() {
		
	}

	public Reservations(String customerName, Date date) {
		super();
		this.customerName = customerName;
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
