package com.deepakmaurya.DemoProject.Impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.deepakmaurya.DemoProject.NotificationService;


@Component
@Qualifier("email")
@ConditionalOnProperty(name="notification.type", havingValue="email")
public class EmailNotificationService implements NotificationService  {
   public void send(String msg) {
	   System.out.println("Email Sending... "+msg);
   }
}
