package com.bosonit.block5properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5PropertiesApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(Block5PropertiesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Block5PropertiesApplication.class, args);
	}

	public void run(String[] args){
		LOG.info("Hola mundo");
	}

}
