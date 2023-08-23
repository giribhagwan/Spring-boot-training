package com.intech.session2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionController {
    @ExceptionHandler(MyException.class)
    public ResponseEntity<String> throwException(){
        return new ResponseEntity<>("NO record found", HttpStatus.BAD_REQUEST);
    }
}
