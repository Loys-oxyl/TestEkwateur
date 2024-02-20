package com.test.ekwateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.test.ekwateur.model.ParticularCalculatorProperties;
import com.test.ekwateur.model.ProfessionalCalculatorProperties;

@SpringBootApplication
@ConfigurationPropertiesScan("com.test.ekwateur.model")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
