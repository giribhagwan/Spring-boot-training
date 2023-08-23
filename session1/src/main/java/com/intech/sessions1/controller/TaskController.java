package com.intech.sessions1.controller;


import com.intech.sessions1.entity.MyTask;
import com.intech.sessions1.repository.TaskRepo;
import com.intech.sessions1.response.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskRepo taskRepo;
    @PostMapping("/")
    public ResponseEntity<ResponseDto> save(@RequestBody MyTask myTask){

      return new ResponseEntity<>(new ResponseDto("save record",
              HttpStatus.CREATED.value(),
              taskRepo.save(myTask))
              , HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<ResponseDto>getAll(){
        return new ResponseEntity<>( new ResponseDto( "fetch record",
                HttpStatus.OK.value(),
                taskRepo.findAll()),
                HttpStatus.OK);
    }
}
