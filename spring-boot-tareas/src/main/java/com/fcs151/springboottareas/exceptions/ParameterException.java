package com.fcs151.springboottareas.exceptions;

public class ParameterException extends RuntimeException {

    private static final long serialVersionUID = -493529332565384767L;

    public ParameterException(String parameter) {
        super("El parametro no es válido: " + parameter);
    }

}

