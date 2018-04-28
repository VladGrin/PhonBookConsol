package com.phonebook.exception;

public class IncorrectInputException extends Exception {
    private String message;

    public IncorrectInputException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
