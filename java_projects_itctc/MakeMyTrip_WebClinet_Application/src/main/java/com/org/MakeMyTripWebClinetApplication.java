package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.org.client.MMTClient;

@SpringBootApplication
public class MakeMyTripWebClinetApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MakeMyTripWebClinetApplication.class, args);
		MMTClient bean = run.getBean(MMTClient.class);
		bean.invokeGetTicket();
		
		bean.invokePostData();
		System.out.println("application runing...8081 port");
	}

}
