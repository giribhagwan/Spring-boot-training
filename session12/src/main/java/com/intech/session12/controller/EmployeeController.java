package com.intech.session12.controller;


import com.intech.session12.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    @GetMapping("index")
    public String indexPath(Model model){
        model.addAttribute("employees",employeeRepo.findAll());
        return "index.html";
    }
    {
    }

}
