package com.example.Testing.EmployeeTest;

import com.example.Testing.EmployeeTest.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EmployeeTestApplication implements CommandLineRunner {



	@Value("${my.variable}")
	private String myVariable;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(myVariable);
//
	}
}
