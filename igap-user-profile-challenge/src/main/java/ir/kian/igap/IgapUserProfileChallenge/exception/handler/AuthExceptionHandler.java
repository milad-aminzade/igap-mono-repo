package ir.kian.igap.IgapUserProfileChallenge.exception.handler;

import ir.kian.igap.IgapUserProfileChallenge.controller.AuthController;
import ir.kian.igap.IgapUserProfileChallenge.exception.UserNotAllowedException;
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
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(assignableTypes = {AuthController.class})
public class AuthExceptionHandler extends BaseExceptionHandler {
    public String getHandler() {
        return "AuthExceptionHandler";
    }

    @ExceptionHandler(value = UserNotAllowedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<APIResultDto> UserNotAllowedExceptionHandler(UserNotAllowedException userNotAllowedException) {
        log.error("{}-UserNotAllowedExceptionHandler :: UserNotAllowedException: ", getHandler(), userNotAllowedException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.UN_AUTHORIZED)
                .detailMessage(userNotAllowedException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }

    @ExceptionHandler(value = UserUnAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<APIResultDto> UserUnAuthorizeExceptionHandler(UserUnAuthorizeException userUnAuthorizeException) {
        log.error("{}-UserUnAuthorizeExceptionHandler :: UserUnAuthorizeException: ", getHandler(), userUnAuthorizeException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.FORBIDDEN)
                .detailMessage(userUnAuthorizeException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }
}
