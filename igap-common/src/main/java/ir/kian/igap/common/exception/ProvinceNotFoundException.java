package ir.kian.igap.common.exception;

public class ProvinceNotFoundException extends NotFoundException {
    private static final String PROVINCE_NOT_FOUND_EXCEPTION_MESSAGE = "Province Not Found !";

    public ProvinceNotFoundException() {
        super(PROVINCE_NOT_FOUND_EXCEPTION_MESSAGE);
    }
}