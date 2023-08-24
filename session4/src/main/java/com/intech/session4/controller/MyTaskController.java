package com.intech.session4.controller;

import com.intech.session4.domain.MyTask;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class MyTaskController {
    List<MyTask> taskList=new ArrayList<>();


    @Operation(
            description = "save task",
            responses = {
                    @ApiResponse(responseCode = "201",
                    description = "save task",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = {
                                           @ExampleObject(value = "{\"id\": long,\"title\": \"string\",\"description\": \"string\"}")
                                    }
                            )
                    }),
                    @ApiResponse(responseCode = "400",ref = "badRequest")
//                    @ApiResponse(responseCode = "400",
//                            description = "Bad Request",
//                            content = {
//                                    @Content(
//                                            mediaType = "application/json",
//                                            examples = {
//                                                    @ExampleObject(value = "{\"message\": \"bad request\",\"code\": \"400\"}")
//                                            }
//                                    )
//                            })
            }
    )
    @PostMapping("")
    public ResponseEntity<MyTask> save(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = {
                    @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(value = "{\"title\": \"string\",\"description\": \"string\"}")
                            }
                    )
            }
    ) @RequestBody MyTask myTask){
        taskList.add(myTask);
        return new ResponseEntity<>(myTask, HttpStatus.CREATED);
    }

    @Operation(
            description = "save task",
            responses = {
                    @ApiResponse(responseCode = "400", ref = "badRequest")
            }
    )
    @GetMapping("")
    public ResponseEntity<List<MyTask>> getAll(){
        return new ResponseEntity<>(taskList,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<MyTask> getById(@PathVariable Long id){
        return new ResponseEntity<>(
                taskList.stream().filter(e-> e.getId()==id).findFirst().get(),
                HttpStatus.OK);
    }
}
