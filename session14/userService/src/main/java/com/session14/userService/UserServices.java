package com.session14.userService;

import com.session14.userService.dto.UserRequestDto;
import com.session14.userService.dto.UserResponseDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServices {
    private UserMasterRepo repo;
    private ModelMapper mapper;

     UserResponseDto save(UserRequestDto userRequestDto){ return mapper.map(repo.save(mapper.map(userRequestDto, UserMaster.class)), UserResponseDto.class); }

    public List<UserResponseDto> getAll() {
         return mapper.map(repo.findAll(),new TypeToken<List<UserResponseDto>>() {}.getType());
     }

    public UserResponseDto getById(Long id) {
         return mapper.map(repo.findById(id).orElseThrow(()-> new IllegalArgumentException("Id Not found")), UserResponseDto.class);
    }
}
