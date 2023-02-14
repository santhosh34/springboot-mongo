package com.aureole.tradeflow;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableMongoRepositories
@SpringBootApplication
@EnableAsync
public class TradeflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeflowApplication.class, args);
	}

}
