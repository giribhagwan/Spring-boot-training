package com.intech.session3;

import com.intech.session3.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Session3ApplicationTests {

	@Autowired
	EmployeeService employeeService;

	@Test
	void contextLoads() {

	}
	@Test
	void addTest(){
		int result=employeeService.add(2,2);
		Assertions.assertEquals(result,4);
	}

}
