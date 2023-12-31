package com.intech.session3.service;

import com.intech.session3.domain.Employee;
import com.intech.session3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public int add(int a, int b){return a+b;}

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        Employee dbEmployee=employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("employee not present"));
        dbEmployee.setName(employee.getName());
        return employeeRepository.save(dbEmployee);
    }
}
