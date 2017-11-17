package com.asiainfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OnlinelogApplication {

	private static Logger logger = LoggerFactory.getLogger(OnlinelogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OnlinelogApplication.class, args);
        logger.info("============================================");
        logger.info("||            Online-Log   Ready            ||");
        logger.info("============================================");
	}
}
