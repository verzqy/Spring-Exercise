package com.example.hello.springjpa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.hello.springjpa.entity.Employee;
import com.example.hello.springjpa.repository.EmployeeRepository;

@SpringBootApplication
public class HelloSpringjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringjpaApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepository repository;
	
	@Bean
	public CommandLineRunner printAll(ApplicationContext ctx) {
		return args -> {
			Employee e = new Employee();
			e.setFirstName("Jefri");
			e.setLastName("Sutejo");
			e.setGender("Male");
			e.setDob(new Date());
			repository.save(e);
		};
	}
	
}
