package com.daikoco.apigateway.exception;

public class UserNotAllowedException extends RuntimeException  {
    private static final String MESSAGE = "user is not allowed!";

    public UserNotAllowedException() {
        super(MESSAGE);
    }

    public UserNotAllowedException(String message) {
        super(message);
    }
}
