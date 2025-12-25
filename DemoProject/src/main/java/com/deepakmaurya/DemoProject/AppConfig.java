package com.deepakmaurya.DemoProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {
 
//	
	@Bean
	PaymentService paymentService() {
		//some more logic before our bean is created
		System.out.println("djhgd");
		return new PaymentService();
	}
	
	
	
	
}
