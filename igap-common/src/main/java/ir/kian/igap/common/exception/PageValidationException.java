package ir.kian.igap.common.exception;

import jakarta.validation.ValidationException;

public class PageValidationException extends ValidationException {
    private final static String PAGE_REQUEST_VALIDATION_EXCEPTION_MESSAGE = "Page Request Validation Exception!";

    public PageValidationException(String message) {
        super(message);
    }

    public PageValidationException() {
        super(PAGE_REQUEST_VALIDATION_EXCEPTION_MESSAGE);
    }
}
