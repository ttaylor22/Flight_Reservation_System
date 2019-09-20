package com.group;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.group.controller.FlightController;


@SpringBootApplication
@EnableJpaRepositories("com.group.repository")
@ComponentScan(basePackageClasses = FlightController.class)
//@EnableAutoConfiguration
public class FrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrsApplication.class, args);
	
	}
	
	

}