package com.deepakmaurya.DemoProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deepakmaurya.DemoProject.Impl.EmailNotificationService;
@SpringBootApplication
public class DemoProjectApplication implements CommandLineRunner {
     
     //@Autowired// field dependency injection
	final NotificationService notificaionObject;

	 //constructor DI
	  public DemoProjectApplication (NotificationService notificaionObject) {
		  this.notificaionObject=notificaionObject;
	  }
	  
    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
    }

    @Override
    public void run(String... args) {
       
      
    	notificaionObject.send("Hello");
    }
}
