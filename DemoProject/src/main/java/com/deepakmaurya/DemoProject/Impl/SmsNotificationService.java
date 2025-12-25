package com.deepakmaurya.DemoProject.Impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.deepakmaurya.DemoProject.NotificationService;

@Component
@Qualifier("sms")
@ConditionalOnProperty(name="notification.type", havingValue="sms")
public class SmsNotificationService implements NotificationService{
   public void send(String msg) {
	   System.out.println("Sms Sending... "+msg);
   }
}
