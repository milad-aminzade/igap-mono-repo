package ir.kian.igap.IgapUserProfileChallenge.exception;

import ir.kian.igap.common.exception.NotAcceptableException;

public class MaxRandomLengthException extends NotAcceptableException {
    private final static String MAX_RANDOM_LENGTH_EXCEPTION_MESSAGE = "Invalid Random length Exception!";

    public MaxRandomLengthException() {
        super(MAX_RANDOM_LENGTH_EXCEPTION_MESSAGE);
    }

    public MaxRandomLengthException(String message) {
        super(message);
    }
}
