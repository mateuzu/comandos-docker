package com.test.testdocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.testdocker.service.UserService;

@SpringBootApplication
public class TestDockerApplication implements CommandLineRunner{

	@Autowired
	private UserService service;
	
	public static void main(String[] args) {
		SpringApplication.run(TestDockerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var list = service.findAll();
		list.forEach(System.out::println);
	}

}
