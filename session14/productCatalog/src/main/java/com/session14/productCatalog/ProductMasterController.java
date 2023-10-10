package com.session14.productCatalog;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductMasterController {
    private ProductMasterServices masterServices;

    @PostMapping("")
    public ResponseEntity<ApiResponseDto> save(@RequestBody ProductMaster productMaster){
        return new ResponseEntity<>(ApiResponseDto.builder()
                .code(HttpStatus.CREATED.value())
                .message("Save successfully")
                .data(masterServices.save(productMaster))
                .build(),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(ApiResponseDto.builder()
                .code(HttpStatus.OK.value())
                .message("fetch successfully")
                .data(masterServices.getById(id))
                .build(),HttpStatus.OK);
    }
    @GetMapping("/stock/{id}")
    public ResponseEntity<ApiResponseDto> getStockById(@PathVariable Long id){
        return new ResponseEntity<>(ApiResponseDto.builder()
                .code(HttpStatus.OK.value())
                .message("fetch successfully")
                .data(masterServices.getProductStockByID(id))
                .build(),HttpStatus.OK);
    }
    @PostMapping("/stock")
    public ResponseEntity<ApiResponseDto> updateStock(@RequestBody ProductStockUpdateDto productStockUpdateDto){
        return new ResponseEntity<>(ApiResponseDto.builder()
                .code(HttpStatus.OK.value())
                .message("Update successfully")
                .data(masterServices.updateStock(productStockUpdateDto))
                .build(),HttpStatus.OK);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponseDto> getMessage(IllegalArgumentException e){
        return new ResponseEntity<>(ExceptionResponseDto.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
