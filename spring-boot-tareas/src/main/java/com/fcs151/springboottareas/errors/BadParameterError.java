package com.fcs151.springboottareas.errors;

import lombok.Data;

@Data
public class BadParameterError implements BaseError {
    private String ERROR_CODE = "15000";
    private String message;
    private String parameter;

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }

}