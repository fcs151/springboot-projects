package com.fcs151.springboottareas.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface BaseError {
    public @JsonProperty("error_code") String getErrorCode();

}
