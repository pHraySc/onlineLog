package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OnlinelogApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinelogApplication.class, args);
	}
}
