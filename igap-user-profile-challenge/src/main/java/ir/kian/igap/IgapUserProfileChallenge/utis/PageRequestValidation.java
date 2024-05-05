package ir.kian.igap.IgapUserProfileChallenge.utis;

import ir.kian.igap.common.config.properties.PaginationProperties;
import ir.kian.igap.common.domain.dto.request.BasePaginationRequestDto;
import ir.kian.igap.common.exception.PageValidationException;
import jakarta.validation.ValidationException;

public class PageRequestValidation {

    private static boolean requestValidation(BasePaginationRequestDto paginationRequestDto) {
        return paginationRequestDto.getPageNumber() >= PaginationProperties.MIN_PAGE_SIZE &&
                paginationRequestDto.getPageSize() <= PaginationProperties.MAX_PAGE_SIZE;
    }

    public static void validate(BasePaginationRequestDto input) throws ValidationException {
        if (!requestValidation(input))
            throw new PageValidationException();
    }
}
