package com.group.FRS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@Configuration
@ComponentScan(basePackages= {"com.group.FRS"})
public class FrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrsApplication.class, args);
	}

}
