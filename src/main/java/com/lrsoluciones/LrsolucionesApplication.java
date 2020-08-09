package com.lrsoluciones;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.lrsoluciones")
public class LrsolucionesApplication  {

	public static void main(String[] args) {
		SpringApplication.run(LrsolucionesApplication.class, args);
		/*Logger logger = LoggerFactory.getLogger(LrsolucionesApplication.class.getName());
		logger.info("funciono");*/
	}

	// recapcha
	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}

}
