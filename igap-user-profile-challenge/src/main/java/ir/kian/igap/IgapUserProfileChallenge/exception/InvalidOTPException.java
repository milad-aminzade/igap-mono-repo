package ir.kian.igap.IgapUserProfileChallenge.exception;

import jakarta.validation.ValidationException;

public class InvalidOTPException extends ValidationException {

    private static final String INVALID_OTP_EXCEPTION = "Invalid OTP";

    public InvalidOTPException() {
        super(INVALID_OTP_EXCEPTION);
    }
}
