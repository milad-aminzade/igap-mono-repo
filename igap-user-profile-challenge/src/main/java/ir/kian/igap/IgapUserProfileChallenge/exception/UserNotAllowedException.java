package ir.kian.igap.IgapUserProfileChallenge.exception;

import ir.kian.igap.common.exception.BaseException;

public class UserNotAllowedException extends RuntimeException implements BaseException {
    private static final String MESSAGE = "user is not allowed!";

    public UserNotAllowedException() {
        super(MESSAGE);
    }

    public UserNotAllowedException(String message) {
        super(message);
    }
}
