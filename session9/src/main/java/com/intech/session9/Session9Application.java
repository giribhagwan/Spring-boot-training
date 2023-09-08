package com.intech.session9;

import com.intech.session9.server.TicketBookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Session9Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Session9Application.class, args);
	}
	@Autowired
	TicketBookingServices ticketBookingServices;

	@Override
	public void run(String... args) throws Exception {
		ticketBookingServices.save();
		ticketBookingServices.t2();
	}
}
