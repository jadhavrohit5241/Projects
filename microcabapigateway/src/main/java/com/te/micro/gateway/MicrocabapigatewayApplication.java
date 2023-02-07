package com.te.micro.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
/* 
 * @EnableHystrix
 */
public class MicrocabapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrocabapigatewayApplication.class, args);
	}

}
