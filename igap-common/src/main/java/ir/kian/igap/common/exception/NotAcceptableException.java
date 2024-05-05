package ir.kian.igap.common.exception;

import org.springframework.web.server.NotAcceptableStatusException;

public class NotAcceptableException extends NotAcceptableStatusException {
    private final static String MESSAGE = "Not acceptable request exception";

    public NotAcceptableException(String reason) {
        super(reason);
    }

    public NotAcceptableException() {
        super(MESSAGE);
    }
}
