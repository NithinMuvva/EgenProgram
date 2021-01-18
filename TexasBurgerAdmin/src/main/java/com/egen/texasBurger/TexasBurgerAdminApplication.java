package com.egen.texasBurger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.egen.texasBurger.controller.LoggingController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class TexasBurgerAdminApplication {

	public static final Logger logger = LogManager.getLogger(LoggingController.class);
	public static void main(String[] args) {
		SpringApplication.run(TexasBurgerAdminApplication.class, args);
	}

}
