package com.intech.session8.controller;

import com.intech.session8.domain.Employee;
import com.intech.session8.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) throws Exception {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }
}
