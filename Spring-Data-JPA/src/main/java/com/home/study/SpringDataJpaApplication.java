package com.home.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {

		return (args) -> {
			repository.save(new Customer("Jack", "Baur"));
			repository.save(new Customer("Gururaj", "Kannur"));
			repository.save(new Customer("Advik", "Kannur"));

			log.info("Customer found with findAll");
			log.info("-----------------------------");
			for (Customer cust : repository.findAll()) {
				log.info(cust.toString());
			}

			log.info(" ");

			// Fetch an individual Customer by ID

			repository.findById(1L).ifPresent(cust -> {
				log.info("Customer found with findById(1L):");
				log.info("--------------------------------");
				log.info(cust.toString());
				log.info("");

			});
			// Fetch Customer by Last name

			log.info("Customer found with findByName(LastName)");
			log.info("--------------------------------");

			repository.findByLastName("Kannur").forEach(kannur -> log.info(kannur.toString()));

			log.info("");

		};
	}
}
