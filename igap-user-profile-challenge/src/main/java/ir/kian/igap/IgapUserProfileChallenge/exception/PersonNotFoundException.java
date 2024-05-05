package ir.kian.igap.IgapUserProfileChallenge.exception;

import ir.kian.igap.common.exception.BaseException;
import jakarta.persistence.EntityNotFoundException;

public class PersonNotFoundException extends EntityNotFoundException implements BaseException {
    private final static String PERSON_NOT_FOUND_EXCEPTION_MESSAGE = "person not found!";

    public PersonNotFoundException() {
        super(PERSON_NOT_FOUND_EXCEPTION_MESSAGE);
    }
}
