package com.juniorjrc.ordernotifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = "com.juniorjrc.ordernotifier")
public class OrderNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderNotifierApplication.class, args);
	}

}
