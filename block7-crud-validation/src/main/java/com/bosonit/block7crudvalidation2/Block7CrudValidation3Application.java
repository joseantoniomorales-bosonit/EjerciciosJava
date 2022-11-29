package com.bosonit.block7crudvalidation2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients
public class Block7CrudValidation3Application implements CommandLineRunner {
	@Autowired(required=true)
	StartData startData;

	public static void main(String[] args) {
		SpringApplication.run(Block7CrudValidation3Application.class, args);
	}

	public void run(String[] args) throws Exception{
		startData.iniSQL();
	}
}
