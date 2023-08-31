package com.intech.session7.autoconfigration;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


public class ApplicationInfo {
    public void info(){
        System.out.println("Welcome in Spring boot training session");
        System.out.println("This is a session7 for auto config");
    }
}
