package com.marcuschiu.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ResfreshScope - allows this config client to refresh the @Value application configurations
 * without it, POST call to localhost:port/refresh will not update the @Value variable
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${test.property:default}")
	String propertyValue;

	@GetMapping("/get-property")
	public String getProperty() {
		return propertyValue;
	}
}
