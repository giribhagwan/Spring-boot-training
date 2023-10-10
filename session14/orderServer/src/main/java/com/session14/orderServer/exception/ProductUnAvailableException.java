package com.session14.orderServer.exception;

public class ProductUnAvailableException extends RuntimeException{

    int code=101;

    public ProductUnAvailableException(String message) {
        super(message);
    }
}
