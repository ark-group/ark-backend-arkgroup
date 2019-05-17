package com.arkbackendarkgroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaServer
@EnableZuulProxy
public class ArkBackendEmployeeApplication {

	public static void main(String[] args) {

		SpringApplication.run(ArkBackendEmployeeApplication.class, args);
	}

}
