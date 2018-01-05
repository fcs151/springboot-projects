package com.fcs151.springboottareas.errors;

import lombok.Data;
import static com.fcs151.springboottareas.utils.Utils.BAD_PARAMETER_CODE;

@Data
public class BadParameterError implements BaseError {
    private String message;

    @Override
    public String getErrorCode() {
        return BAD_PARAMETER_CODE;
    }

}