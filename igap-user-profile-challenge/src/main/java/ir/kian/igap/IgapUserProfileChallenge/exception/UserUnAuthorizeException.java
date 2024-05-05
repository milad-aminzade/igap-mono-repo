package ir.kian.igap.IgapUserProfileChallenge.exception;

public class UserUnAuthorizeException extends RuntimeException implements BaseException {
    private static final String AUTHORIZATION_EXCEPTION_MESSAGE = "UnAuthorized";

    public UserUnAuthorizeException(String message) {
        super(message);
    }

    public UserUnAuthorizeException() {
        super(AUTHORIZATION_EXCEPTION_MESSAGE);
    }
}
