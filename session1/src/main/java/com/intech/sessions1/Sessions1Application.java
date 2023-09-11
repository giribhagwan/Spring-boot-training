package com.intech.sessions1;

import com.intech.sessions1.autoconfig.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class Sessions1Application implements CommandLineRunner {

	@Autowired
	WebApplicationContext applicationContext;

	public static void main(String[] args) {

		SpringApplication.run(Sessions1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationInfo info=applicationContext.getBean(ApplicationInfo.class);
		info.showInfo();
	}

}
