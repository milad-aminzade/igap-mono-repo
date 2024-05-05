package ir.kian.igap.IgapUserProfileChallenge.exception.handler;

import ir.kian.igap.IgapUserProfileChallenge.exception.UserUnAuthorizeException;
import ir.kian.igap.common.domain.dto.restapi.result.APIResultDto;
import ir.kian.igap.common.domain.dto.restapi.result.APIResultDtoWithData;
import ir.kian.igap.common.domain.dto.restapi.result.Context;
import ir.kian.igap.common.domain.dto.restapi.result.enumstatus.BaseStatusEnum;
import ir.kian.igap.common.exception.handlers.BaseExceptionHandler;
import ir.kian.igap.common.transformer.impl.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ir.kian.igap.IgapUserProfileChallenge.exception.UserNotAllowedException;
@Slf4j
public class AuthExceptionHandler extends BaseExceptionHandler {
    public String getHandler() {
        return "AuthExceptionHandler";
    }

    @ExceptionHandler(value = UserNotAllowedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<APIResultDto> UserNotAllowedExceptionHandler(UserNotAllowedException userNotAllowedException) {
        log.error("{}-internalServerErrorExceptionHandler :: runtimeException: ", getHandler(), userNotAllowedException);
        log.error(userNotAllowedException.getMessage(), userNotAllowedException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.UN_AUTHORIZED)
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }

    @ExceptionHandler(value = UserUnAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<APIResultDto> UserUnAuthorizeExceptionHandler(UserUnAuthorizeException userUnAuthorizeException) {
        log.error("{}-internalServerErrorExceptionHandler :: runtimeException: ", getHandler(), userUnAuthorizeException);
        log.error(userUnAuthorizeException.getMessage(), userUnAuthorizeException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.FORBIDDEN)
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }
}
