package com.example.demir_test.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO {

    private Date timestamp;
    private String message;
    private String details;
}
