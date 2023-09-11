package com.intech.session3.controller;

import com.intech.session3.domain.Employee;
import com.intech.session3.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.intech.session3.config.PathConstant.EMPLOYEE_CONTROLLER_PATH;

@RestController
@RequestMapping(value = EMPLOYEE_CONTROLLER_PATH)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Operation(
            description = "save employee",
            responses = {
                    @ApiResponse(responseCode = "400",ref = "badRequestAPI"),
                    @ApiResponse(
                            responseCode = "201",
                            description = "save successfully",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            examples = {
                                                    @ExampleObject(
                                                            value = "{\"code\":201,\"Status\":CREATED,\"message\":\"save successfully\"}"
                                                    )
                                            }
                                    )
                            }
                    )
            }
    )
    @PostMapping()
    public ResponseEntity<Employee> save(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = {
                    @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            value = "{\"name\": \"string\",\"department\": \"string\",\"city\": \"string\"}"
                                    )
                            }
                    )
            }
    ) @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee),
                HttpStatus.CREATED);
    }
    @PostMapping("{id}")
    public ResponseEntity<Employee> update( @PathVariable Long id,
   @RequestBody Employee employee ) {
        return new ResponseEntity<>(employeeService.update(id,employee),
                HttpStatus.CREATED);
    }
}
