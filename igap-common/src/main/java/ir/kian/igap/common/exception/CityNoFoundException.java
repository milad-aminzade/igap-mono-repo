package ir.kian.igap.common.exception;

public class CityNoFoundException extends NotFoundException {
    private static final String CITY_NOT_FOUND = "City not found!";

    public CityNoFoundException() {
        super(CITY_NOT_FOUND);
    }
}