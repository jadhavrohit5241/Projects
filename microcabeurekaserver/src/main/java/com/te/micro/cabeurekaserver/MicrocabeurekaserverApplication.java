package com.te.micro.cabeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicrocabeurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrocabeurekaserverApplication.class, args);
	}

}
