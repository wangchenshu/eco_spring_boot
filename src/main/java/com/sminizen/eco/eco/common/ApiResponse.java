package com.sminizen.eco.eco.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResponse {

    private int status;
    @JsonIgnore
    private String message;
    private Object data;
}
