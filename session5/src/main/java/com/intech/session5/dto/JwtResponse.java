package com.intech.session5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public  class JwtResponse {
    String jwtToken;
    String username;
}