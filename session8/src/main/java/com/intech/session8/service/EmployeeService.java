package com.intech.session8.service;

import com.intech.session8.domain.Employee;

public interface EmployeeService {
    Employee save(Employee employee) throws Exception;
    void delete();
    Employee update();
}
