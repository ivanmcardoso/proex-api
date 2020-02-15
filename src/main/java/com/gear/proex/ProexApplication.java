package com.gear.proex;

import com.gear.proex.config.property.ProexProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProexProperty.class)
public class ProexApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProexApplication.class, args);
	}

}
