package com.financeModule.CRUD.Exceptions;

public class ClientHasProjectsException extends RuntimeException {

    // Constructor to initialize the exception with a custom message
    public ClientHasProjectsException(String message) {
        super(message);
    }
}
