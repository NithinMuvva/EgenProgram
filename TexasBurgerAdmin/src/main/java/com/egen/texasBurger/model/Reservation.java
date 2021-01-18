package com.egen.texasBurger.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "reservations")
public class Reservation {
	@Id
	private String id;
	private String fullName;
	private String contact;
	private String email;
	private Date dateOfBooking;
	private Date dateOfEvent;
	private String eventCategory;
	private String eventPackageSelected;
	private String status;
}
