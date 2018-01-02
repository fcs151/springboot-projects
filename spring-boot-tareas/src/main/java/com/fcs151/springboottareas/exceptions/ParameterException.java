package com.fcs151.springboottareas.exceptions;

public class ParameterException extends RuntimeException {

    private static final long serialVersionUID = -493529332565384767L;

    public ParameterException(String msg) {
        super(msg);
    }

    public ParameterException(String msg, Throwable t) {
        super(msg, t);
    }

}

