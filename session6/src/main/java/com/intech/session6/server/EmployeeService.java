package com.intech.session6.server;

import com.intech.session6.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employeeList=new ArrayList<>(Arrays.asList(
            Employee.builder().name("user1").department("IT").city("Pune").build(),
            Employee.builder().name("user2").department("IT").city("Pune").build(),
            Employee.builder().name("user3").department("IT").city("Pune").build(),
            Employee.builder().name("user4").department("IT").city("Pune").build()

    ));
    public List<Employee> getAll() {
        return employeeList;
    }
}
