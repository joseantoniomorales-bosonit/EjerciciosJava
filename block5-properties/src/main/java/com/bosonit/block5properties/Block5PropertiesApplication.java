package com.bosonit.block5properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5PropertiesApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(Block5PropertiesApplication.class);

	@Value("${greeting}")
	private String greeting;
	@Value("${new.property:no tiene valor}")
	private String newProperty;
	@Value("${my.number}")
	private int myNumber;

	public static void main(String[] args) {
		SpringApplication.run(Block5PropertiesApplication.class, args);
	}

	public void run(String[] args){
		LOG.info("El valor de greeting es: "+this.greeting);
		LOG.info("El valor de my.number es: "+this.myNumber);
		LOG.info("El valor de new.property es: "+this.newProperty);
	}

}
