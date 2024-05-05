package ir.kian.igap.IgapUserProfileChallenge.exception;

import ir.kian.igap.common.exception.BaseException;
import jakarta.persistence.EntityNotFoundException;

public class ProfileNotFoundException extends EntityNotFoundException implements BaseException {
    private final static String PROFILE_NOT_FOUND_EXCEPTION_MESSAGE = "Profile file not found!";

    public ProfileNotFoundException() {
        super(PROFILE_NOT_FOUND_EXCEPTION_MESSAGE);
    }
}
