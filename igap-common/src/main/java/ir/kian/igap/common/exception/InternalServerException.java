package ir.kian.igap.common.exception;

public class InternalServerException extends RuntimeException implements BaseException {

    private static final String INTERNAL_SERVER_EXCEPTION_MESSAGE = "Internal Server Exception!";

    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException() {
        super(INTERNAL_SERVER_EXCEPTION_MESSAGE);
    }
}
