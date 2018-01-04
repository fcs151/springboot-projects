package com.fcs151.springboottareas.errors;

import lombok.Data;

@Data
public class BadParameterError implements BaseError {
    private String message;

    @Override
    public String getErrorCode() {
        return "1";
    }

}