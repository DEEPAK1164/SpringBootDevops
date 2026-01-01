package com.example.Modeule3.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Modeule3.entities.Product;
import com.example.Modeule3.repositories.ProductRepository;

@RestController
@RequestMapping(path="/products")
public class ProductController {
  private final int PAGE_SIZE=5;
	private final ProductRepository productRepository;
	public ProductController( ProductRepository productRepository)
	{
		this.productRepository=productRepository;
	}
	
//	@GetMapping
//	public List<Product>getAllProducts(){
//		return productRepository.findByOrderByPrice();
//	}
	
//	@GetMapping
//	public List<Product>getAllProducts(@RequestParam(defaultValue="id") String sortBy){
//		return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy));
//	}

	
//	@GetMapping
//	public List<Product>getAllProducts(@RequestParam(defaultValue="id") String sortBy){
//		return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy));
//	}


//	@GetMapping
//	public Page<Product>getAllProducts(@RequestParam(defaultValue="0") Integer pageNumber){
//		PageRequest pageable=PageRequest.of(pageNumber,PAGE_SIZE);
//		
//		return productRepository.findAll(pageable);
//	}
	
	

//	@GetMapping
//	public Page<Product>getAllProducts(@RequestParam(defaultValue="id") String sortBy,@RequestParam(defaultValue="0") Integer pageNumber){
//		PageRequest pageable=PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy));
//		
//		return productRepository.findAll(pageable);
//	}
	
	@GetMapping
	public List<Product>getAllProducts(@RequestParam(defaultValue="id") String sortBy,@RequestParam(defaultValue="0") Integer pageNumber){
		PageRequest pageable=PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy));
		
		return productRepository.findAll(pageable).getContent();
	}
	
}
