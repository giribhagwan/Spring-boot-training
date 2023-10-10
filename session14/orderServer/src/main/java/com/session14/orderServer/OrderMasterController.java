package com.session14.orderServer;

import com.session14.orderServer.dto.ApiResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderMasterController {
    private OrderMasterServices orderMasterServices;

    @PostMapping("")
    public ResponseEntity<ApiResponseDto> save(@RequestBody OrderMaster order){
        return new ResponseEntity<>(ApiResponseDto.builder()
                .code(HttpStatus.CREATED.value())
                .message("Save successfully")
                .data(orderMasterServices.save(order))
                .build(),HttpStatus.CREATED);
    }
}
