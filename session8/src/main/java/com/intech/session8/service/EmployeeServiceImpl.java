package com.intech.session8.service;

import com.intech.session8.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> employeeList=new ArrayList<>();
    @Override
    public Employee save(Employee employee) throws Exception {
        employeeList.add(employee);
//        throw new Exception("custom Exception");
        return employee;
    }

    @Override
    public void delete() {

    }

    @Override
    public Employee update() {
        return null;
    }
}
