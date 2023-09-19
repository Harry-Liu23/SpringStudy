package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@MapperScan("com.example.dao.UserMapper")
//@EnableJpaRepositories("com.example.repository")
public class ProviderUserApplication {
	public static void main(String[] args){
		SpringApplication.run(ProviderUserApplication.class, args);
	}



}
