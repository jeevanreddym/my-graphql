package com.my.graphql.learn.mygraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class MyGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyGraphqlApplication.class, args);
	}

	@GetMapping("/say-hello")
	public String sayHello() {
		return "Hello GQL";
	}

}
