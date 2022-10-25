package com.bosonit.block5logging;

import ch.qos.logback.classic.filter.ThresholdFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5LoggingApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Block5LoggingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Block5LoggingApplication.class, args);
		LOG.error("Te ha reventado el programa!");
		LOG.warn("Cuidaoooooooooooooooo");
		LOG.info("Te informo");
	}

	public void run(String[] args){

	}
}
