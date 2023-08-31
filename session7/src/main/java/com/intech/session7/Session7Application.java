package com.intech.session7;

import com.intech.session7.autoconfigration.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class Session7Application implements CommandLineRunner {

	@Autowired
	WebApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(Session7Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationInfo info= context.getBean(ApplicationInfo.class);
		info.info();
	}

}
