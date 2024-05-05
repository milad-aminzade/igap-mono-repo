package ir.kian.igap.IgapUserProfileChallenge.exception;

public class UserNotAllowedException extends RuntimeException implements BaseException {
    private static final String MESSAGE = "user is not allowed!";

    public UserNotAllowedException() {
        super(MESSAGE);
    }

    public UserNotAllowedException(String message) {
        super(message);
    }
}
