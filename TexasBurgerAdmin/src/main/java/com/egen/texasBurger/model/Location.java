package com.egen.texasBurger.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "locations")
@Data
public class Location {
	@Id
	private String locationId;
	private String name;
	private Double latitude;
	private Double longitude;
	private String address;
	private String phone;
}
