package ir.kian.igap.common.exception;

public class DuplicateException extends RuntimeException implements BaseException {
    public DuplicateException(String message) {
        super(message);
    }
}
