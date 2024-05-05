package ir.kian.igap.common.exception;

public class NotDeliveredException extends InternalServerException {
    private static final String NotDeliveredExceptionMessage = "Service is not deliver!";

    public NotDeliveredException(String message) {
        super(message);
    }

    public NotDeliveredException() {
        super(NotDeliveredExceptionMessage);
    }
}