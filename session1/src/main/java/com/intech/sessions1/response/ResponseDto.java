package com.intech.sessions1.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseDto {
    public String message;
    public int code;
    public Object data;
}
