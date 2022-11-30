package com.example.demir_test.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyException extends RuntimeException {

    private String HttpStatus;
    private String message;

    public MyException(String message, Throwable cause, String httpStatus) {
        super(message, cause);
        HttpStatus = httpStatus;
    }
}