package com.session14.userService;


import com.session14.userService.dto.ApiResponseDto;
import com.session14.userService.dto.ExceptionResponseDto;
import com.session14.userService.dto.UserRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserMasterController {
    private UserServices UserServices;
    @PostMapping("")
    public ResponseEntity<ApiResponseDto> save(@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(ApiResponseDto.builder()
                .message("Save successfully")
                .code(HttpStatus.CREATED.value())
                .data(UserServices.save(userRequestDto))
                .build(),HttpStatus.CREATED);
    }
    @GetMapping("")
    public ResponseEntity<ApiResponseDto> getAll(){
        return new ResponseEntity<>(ApiResponseDto.builder()
                .message("fetch successfully")
                .code(HttpStatus.OK.value())
                .data(UserServices.getAll())
                .build(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(ApiResponseDto.builder()
                .message("fetch successfully")
                .code(HttpStatus.OK.value())
                .data(UserServices.getById(id))
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
