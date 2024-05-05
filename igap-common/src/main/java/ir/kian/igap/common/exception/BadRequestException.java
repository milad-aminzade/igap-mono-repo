package ir.kian.igap.common.exception;

import jakarta.validation.ValidationException;

public class BadRequestException extends ValidationException implements BaseException {
    public BadRequestException(String message) {
        super(message);
    }
}
