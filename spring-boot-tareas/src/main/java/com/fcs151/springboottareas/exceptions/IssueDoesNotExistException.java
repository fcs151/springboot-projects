package com.fcs151.springboottareas.exceptions;

public class IssueDoesNotExistException extends RuntimeException {

    private static final long serialVersionUID = 81441424739031833L;
    
    public IssueDoesNotExistException() {
        super("Issue doesn't exist.");
    }
    
    public IssueDoesNotExistException(int id) {
        super("Issue doesn't exist. Id: " + id);
    }
    
}
