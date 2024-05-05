package com.daikoco.apigateway.exception;

public class UserUnAuthorizeException extends RuntimeException {
    private final static String UserUnAuthorizeExceptionMessage = "User is Un Authorized!";

    public UserUnAuthorizeException() {
        super(UserUnAuthorizeExceptionMessage);
    }

    public UserUnAuthorizeException(String message) {
        super(message);
    }

}
