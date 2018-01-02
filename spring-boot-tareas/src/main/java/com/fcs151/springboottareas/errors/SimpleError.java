package com.fcs151.springboottareas.errors;

import lombok.Data;

@Data
public class SimpleError implements BaseError {
    private static final String ERROR_CODE = "error.api";
    private String message;

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }

}
