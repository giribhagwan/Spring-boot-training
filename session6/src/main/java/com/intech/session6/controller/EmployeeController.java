package com.intech.session6.controller;

import com.intech.session6.domain.Employee;
import com.intech.session6.server.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }
}
