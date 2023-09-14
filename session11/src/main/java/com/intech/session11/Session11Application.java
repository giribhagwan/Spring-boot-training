package com.intech.session11;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.text.MessageFormat;

@SpringBootApplication
public class Session11Application {

	public static void main(String[] args) {
		SpringApplication.run(Session11Application.class, args);
	}

	@Value("${app.name}")
	String appName;

	@PostConstruct
	public void getInfo(){
		System.out.println(MessageFormat.format("We are in the {0}",appName));
	}

	@Autowired
	@Qualifier("AppServiceDev")
	AppService appService;
	@Bean
	public void printInfo(){
		appService.getAppInfo();
	}
}
