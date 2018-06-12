package com.phonebook.exception;

public class DataAlreadyExistsException extends Exception {
    private String message;

    public DataAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {

        return message;
    }
}
