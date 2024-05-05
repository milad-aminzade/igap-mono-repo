package ir.kian.igap.IgapUserProfileChallenge.exception;

import jakarta.validation.ValidationException;

public class MobileInvalidException extends ValidationException {
    private final static String MOBILE_INVALID_EXCEPTION = "Invalid mobile number";

    public MobileInvalidException(String message) {
        super(message);
    }

    public MobileInvalidException() {
        super(MOBILE_INVALID_EXCEPTION);
    }

}
