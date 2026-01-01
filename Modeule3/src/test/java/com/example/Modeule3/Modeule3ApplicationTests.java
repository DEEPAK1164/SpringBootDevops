package com.example.Modeule3;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.Modeule3.entities.Product;

import com.example.Modeule3.repositories.ProductRepository;


@SpringBootTest
@Disabled("Disabled until DB setup is fixed")
class Modeule3ApplicationTests {

	@Autowired 
	ProductRepository productRepository;
	
	
	@Test
	void contextLoads() {
		
	}
    
	@Test
	void createRepository() {
		productRepository.deleteAll();
		Product product=Product.builder()
				.sku("Nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(123)
				.build();
		
		Product savedProduct=productRepository.save(product);
		System.out.println(savedProduct);
	}
	
	@Test
	void getRepository() {
		List<Product> products=productRepository.findAll();
		System.out.println(products);
	}
	
	@Test
	void getByTitleRepository() {
		List<Product> products=productRepository.findByTitle("Nestle Chocolate");
		System.out.println(products);
	}
	@Test
	void getProductAfterCreatedRepository() {
		List<Product> products=productRepository.findByCreatedAtAfter(LocalDateTime.of(2026, 1, 1, 15, 0));
		System.out.println(products);
	}
	
	@Test
	void getProductByTitleAndPriceRepository() {
		Optional<Product> product=productRepository.findByTitleAndPrice("Nestle Chocolate",(BigDecimal.valueOf(123.45)));
		System.out.println(product);
	}
	
	
	
	
}
