package com.egen.texasBurger.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "menu")
public class Menu extends Category{
	@Id
	private String mid;
	private String mtype;
	private String item;
	private String price;
}