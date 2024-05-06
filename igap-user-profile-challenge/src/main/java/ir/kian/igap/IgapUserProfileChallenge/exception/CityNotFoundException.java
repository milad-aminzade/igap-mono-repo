package ir.kian.igap.IgapUserProfileChallenge.exception;

import ir.kian.igap.common.exception.BaseException;
import jakarta.persistence.EntityNotFoundException;


public class CityNotFoundException extends EntityNotFoundException implements BaseException {
    private final static String CITY_NOT_FOUND_EXCEPTION_MESSAGE = "City not found!";

    public CityNotFoundException() {
        super(CITY_NOT_FOUND_EXCEPTION_MESSAGE);
    }
}