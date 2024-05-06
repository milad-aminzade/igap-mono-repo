package ir.kian.igap.IgapUserProfileChallenge.exception.handler;

import ir.kian.igap.IgapUserProfileChallenge.controller.PersonController;
import ir.kian.igap.IgapUserProfileChallenge.exception.CityNotFoundException;
import ir.kian.igap.IgapUserProfileChallenge.exception.InvalidOTPException;
import ir.kian.igap.IgapUserProfileChallenge.exception.MaxRandomLengthException;
import ir.kian.igap.IgapUserProfileChallenge.exception.PersonNotFoundException;
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
@RestControllerAdvice(assignableTypes = {PersonController.class})
public class PersonExceptionHandler extends BaseExceptionHandler {
    public String getHandler() {
        return "PersonExceptionHandler";
    }


    @ExceptionHandler(value = InvalidOTPException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<APIResultDto> UserNotAllowedExceptionHandler(InvalidOTPException invalidOTPException) {
        log.error("{}-UserNotAllowedExceptionHandler :: runtimeException: ", getHandler(), invalidOTPException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.VALIDATION_ERROR)
                .detailMessage(invalidOTPException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }

    @ExceptionHandler(value = MaxRandomLengthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<APIResultDto> UserUnAuthorizeExceptionHandler(MaxRandomLengthException maxRandomLengthException) {
        log.error("{}-UserUnAuthorizeExceptionHandler :: runtimeException: ", getHandler(), maxRandomLengthException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.INTERNAL_SERVER_ERROR)
                .detailMessage(maxRandomLengthException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }

    @ExceptionHandler(value = PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<APIResultDto> UserUnAuthorizeExceptionHandler(PersonNotFoundException personNotFoundException) {
        log.error("{}-UserUnAuthorizeExceptionHandler :: PersonNotFoundException: ", getHandler(), personNotFoundException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.NOT_FOUND)
                .detailMessage(personNotFoundException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }


    @ExceptionHandler(value = CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<APIResultDto> CityNotFoundExceptionHandler(CityNotFoundException cityNotFoundException) {
        log.error("{}-CityNotFoundExceptionHandler :: cityNotFoundException: ", getHandler(), cityNotFoundException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.NOT_FOUND)
                .detailMessage(cityNotFoundException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }
}
