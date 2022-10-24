package com.bosonit.demo;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner {

	@Autowired
	private Clase3 c3;
	private static final Logger log = LoggerFactory.getLogger(Block5CommandLineRunnerApplication.class);

	public static void main(String[] args) {
		log.info("Antes de ejecutar");
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
		log.info("Despues de ejecutar");
	}

	@PostConstruct
	public  void ejecutame() {
		System.out.println("Linea a ejecutar cuando arranque");
	}

	@Override
	public void run(String... args) throws Exception {
		ejecutame();
		saludo3();
	}

	@Bean
	CommandLineRunner saludo3 (){
		String[] saludo = {"Soy la tercera clase"};
		return c3.ejecutame3(saludo);
	}
}