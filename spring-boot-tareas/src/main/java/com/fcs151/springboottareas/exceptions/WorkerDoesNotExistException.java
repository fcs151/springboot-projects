package com.fcs151.springboottareas.exceptions;

public class WorkerDoesNotExistException extends RuntimeException {

    private static final long serialVersionUID = -3643121651335026020L;
    
    public WorkerDoesNotExistException() {
        super("Worker doesn't exist.");
    }
    
    public WorkerDoesNotExistException(int id) {
        super("Worker doesn't exist. Id: " + id);
    }
    
}
