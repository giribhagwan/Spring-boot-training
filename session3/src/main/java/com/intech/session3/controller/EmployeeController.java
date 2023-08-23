package com.intech.session3.controller;

import com.intech.session3.domain.Employee;
import com.intech.session3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.intech.session3.config.PathConstant.EMPLOYEE_CONTROLLER_PATH;

@RestController
@RequestMapping(value = EMPLOYEE_CONTROLLER_PATH)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping()
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.save(employee),
                HttpStatus.CREATED);
    }
}
