package com.intech.session10.controller;

import com.intech.session10.domain.Book;
import com.intech.session10.dto.AppResponse;
import com.intech.session10.services.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {
    private BookService bookService;
    @PostMapping("")
    public ResponseEntity<AppResponse> save(@RequestBody Book book){
        return new ResponseEntity<>(AppResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message("Record added")
                .data(bookService.save(book))
                .build(),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AppResponse> getById(@PathVariable Long id){
        return new ResponseEntity<>(AppResponse.builder()
                .code(HttpStatus.OK.value())
                .message("Record added")
                .data(bookService.getById(id))
                .build(),HttpStatus.OK);
    }
    @PutMapping("")
    public ResponseEntity<AppResponse> update(@RequestBody Book book){
        return new ResponseEntity<>(AppResponse.builder()
                .code(HttpStatus.OK.value())
                .message("updated Record")
                .data(bookService.update(book))
                .build(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<AppResponse> delete(@PathVariable Long id){
        return new ResponseEntity<>(AppResponse.builder()
                .code(HttpStatus.OK.value())
                .message("Record deleted")
                .data(bookService.delete(id))
                .build(),HttpStatus.OK);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundException(EntityNotFoundException e){
        return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
    }
}
