package com.intech.session5.controller;

import com.intech.session5.dmain.MyTask;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class MyTaskManagerController {

    List<MyTask> taskList=new ArrayList<>(Arrays.asList(
            new MyTask("title1","description1"),
            new MyTask("title2","description2"),
            new MyTask("title3","description3"),
            new MyTask("title4","description4"),
            new MyTask("title5","description5")
    ));
    @GetMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<MyTask>> getAll(){
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }
}
