package com.intech.session6.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {
    String jwtToken;
    String username;

}
