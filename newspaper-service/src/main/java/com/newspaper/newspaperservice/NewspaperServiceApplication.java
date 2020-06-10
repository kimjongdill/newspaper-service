package com.newspaper.newspaperservice;

import com.newspaper.newspaperservice.controller.LeaderPubClient;
import feign.Feign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class NewspaperServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewspaperServiceApplication.class, args);
	}



}
