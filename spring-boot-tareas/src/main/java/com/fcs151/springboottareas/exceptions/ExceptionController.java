package com.fcs151.springboottareas.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fcs151.springboottareas.errors.BadParameterError;

@ControllerAdvice
public class ExceptionController {
    
    private static final Logger logger = Logger.getLogger(ExceptionController.class);
    
    @ExceptionHandler({ParameterException.class })
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody BadParameterError parameterException(Exception e) {
        BadParameterError error = new BadParameterError();
        error.setMessage(e.getMessage());
        logger.info("Bad Parameter: " + e.getMessage());
        return error;
    }
    
}
