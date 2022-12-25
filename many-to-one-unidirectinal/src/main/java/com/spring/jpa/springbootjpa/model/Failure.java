package com.spring.jpa.springbootjpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Failure {
    private int errorCode;
    private String errorDetail;
    private String developerMessage;
}
