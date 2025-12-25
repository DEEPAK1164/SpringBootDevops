package com.deepakmaurya.DemoProject;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class PaymentService {
  public void pay() {
	  System.out.println("Paying the money...");
  }
//  
//  
//  @PostConstruct
//  public void f1() {
//	  System.out.println("Before Paying..");
//  }
//  
//  @PostConstruct
//  public void f2() {
//	  System.out.println("After Paying..");
//  }
}
