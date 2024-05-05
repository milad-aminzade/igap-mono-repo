package ir.kian.igap.common.exception;

public class NotFoundException extends RuntimeException implements BaseException {
    public NotFoundException(String message) {
        super(message);
    }
}
