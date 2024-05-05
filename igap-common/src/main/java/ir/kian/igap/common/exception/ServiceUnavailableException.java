package ir.kian.igap.common.exception;

public class ServiceUnavailableException extends RuntimeException implements BaseException {
    private final static String SERVICE_UNAVAILABLE_EXCEPTION_MESSAGE = "Service Unavailable!";

    public ServiceUnavailableException(String message) {
        super(message);
    }

    public ServiceUnavailableException() {
        super(SERVICE_UNAVAILABLE_EXCEPTION_MESSAGE);
    }
}
