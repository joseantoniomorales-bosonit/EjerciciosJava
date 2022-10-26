package com.bosonit.block5profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Block5ProfilesApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Block5ProfilesApplication.class);
	@Autowired
	ProfileController pC;

	public static void main(String[] args) {
		SpringApplication.run(Block5ProfilesApplication.class, args);
	}

	public void run(String[] args) throws Exception{

	}

	@Bean
	@Profile("local")
	CommandLineRunner exeLocal(){
		return p -> {
			System.out.println(pC.toString());
		};
	}

	@Bean
	@Profile("INT")
	CommandLineRunner exeINT(){
		return p -> {
			System.out.println(pC.toString());
		};
	}

	@Bean
	@Profile("PRO")
	CommandLineRunner exePRO(){
		return p -> {
			System.out.println(pC.toString());
		};
	}
}
