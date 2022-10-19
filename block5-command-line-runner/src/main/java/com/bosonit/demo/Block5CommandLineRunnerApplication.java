package com.bosonit.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(Block5CommandLineRunnerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
		log.info("Hola");
	}

	@Override
	public void run(String[] args) throws Exception{
		log.info("Dentro del metodo run");
	}
}
