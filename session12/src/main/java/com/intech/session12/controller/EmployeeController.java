package com.intech.session12.controller;


import com.intech.session12.dmain.Employee;
import com.intech.session12.repository.EmployeeRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("index")
    public String indexPath(Model model) {
        model.addAttribute("employees", employeeRepo.findAll());
        return "index.html";
    }

    @PostMapping("addemployee")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-employee";
        }
        employeeRepo.save(employee);
        return "redirect:/index";
    }

    @GetMapping("sigup")
    public String sigUp(Employee employee) {
        return "add-employee";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with Id: " + id + " not found"));
        model.addAttribute("employee", employee);
        return "update-employee.html";
    }

    @PostMapping("update/{id}")
    public String updateUpdate(@Valid Employee employee, BindingResult result, Model model) {
        {
            if (result.hasErrors()) {
                return "update-employee";
            }
            employeeRepo.save(employee);
            return "redirect:/index";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model){
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with Id: " + id + " not found"));
        employeeRepo.deleteById(id);
        return "redirect:/index";
    }
}
