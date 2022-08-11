package com.example.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/*
By default, Spring Boot enables JPA repository support and looks in the package (and its subpackages)
 where @SpringBootApplication is located. If your configuration has JPA repository interface
 definitions located in a package that is not visible, you can point out alternate packages by using
 @EnableJpaRepositories and its type-safe basePackageClasses=MyRepository.class parameter.
**/
@SpringBootApplication
public class SpringdatajpaApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringdatajpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DataRepository dataRepository){
		return (args) -> {

			// Creating some users
			dataRepository.save(new DataModel("Jack", "Bauer"));
			dataRepository.save(new DataModel("Chloe", "O'Brian"));
			dataRepository.save(new DataModel("Kim", "Bauer"));
			dataRepository.save(new DataModel("David", "Palmer"));
			dataRepository.save(new DataModel("Michelle", "Dessler"));

			// fetch all users
			log.info("users found with findAll:");
			log.info("-----------------------------");
			for(DataModel user: dataRepository.findAll()){
				log.info(user.toString());
			}
			log.info("");

			// fetch user by Id
			DataModel user = dataRepository.findById(1L);
			log.info("user found with findById(1L):");
			log.info("---------------------------------");
			log.info(user.toString());
			log.info("");

			// fetch user by Last Name
			log.info("user found with findByLastName('Bauer'):");
			log.info("----------------------------------------");
			dataRepository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("");

		};
	}
}
