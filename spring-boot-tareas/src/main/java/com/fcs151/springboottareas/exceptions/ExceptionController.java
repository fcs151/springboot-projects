package com.fcs151.springboottareas.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fcs151.springboottareas.errors.BadParameterError;
import com.fcs151.springboottareas.errors.SimpleError;

@ControllerAdvice
public class ExceptionController {
    
    private static final Logger logger = Logger.getLogger(ExceptionController.class);
    
    @ExceptionHandler({IssueDoesNotExistException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody BadParameterError parameterException(IssueDoesNotExistException e) {
        BadParameterError error = new BadParameterError();
        error.setMessage(e.getMessage());
        logger.info("Bad Parameter: " + e.getMessage());
        return error;
    }
    
    @ExceptionHandler({WorkerDoesNotExistException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody BadParameterError parameterException(WorkerDoesNotExistException e) {
        BadParameterError error = new BadParameterError();
        error.setMessage(e.getMessage());
        logger.info("Bad Parameter: " + e.getMessage());
        return error;
    }
    
    @ExceptionHandler({Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody SimpleError exception(Exception e) {
        logger.error("An exception has been thrown {}: " + e.getMessage());
        SimpleError error = new SimpleError();
        error.setMessage(e.getMessage());
        return error;
    }
    
}
