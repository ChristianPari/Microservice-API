package com.christianpari.nbaplayerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NbaPlayerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbaPlayerServiceApplication.class, args);
	}

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() { return new RestTemplate(); }
}
