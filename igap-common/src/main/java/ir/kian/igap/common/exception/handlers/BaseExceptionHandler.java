package ir.kian.igap.common.exception.handlers;
import ir.kian.igap.common.domain.dto.restapi.result.APIResultDto;
import ir.kian.igap.common.domain.dto.restapi.result.APIResultDtoWithData;
import ir.kian.igap.common.domain.dto.restapi.result.Context;
import ir.kian.igap.common.domain.dto.restapi.result.enumstatus.BaseStatusEnum;
import ir.kian.igap.common.exception.DuplicateException;
import ir.kian.igap.common.exception.NotFoundException;
import ir.kian.igap.common.exception.PageValidationException;
import ir.kian.igap.common.exception.ServiceUnavailableException;
import ir.kian.igap.common.transformer.impl.ResponseHandler;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@AllArgsConstructor
public class BaseExceptionHandler {
    public String getHandler() {
        return "BaseExceptionHandler";
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<APIResultDto> internalServerErrorExceptionHandler(RuntimeException runtimeException) {
        log.error("{}-internalServerErrorExceptionHandler :: runtimeException: ", getHandler(), runtimeException);
        log.error(runtimeException.getMessage(), runtimeException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.INTERNAL_SERVER_ERROR)
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<APIResultDto> entityNotFoundExceptionHandler(EntityNotFoundException entityNotFoundException) {
        log.error("{}-entityNotFoundExceptionHandler :: EntityNotFoundException: ", getHandler(), entityNotFoundException);
        log.debug(entityNotFoundException.getMessage(), entityNotFoundException);

        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.NOT_FOUND)
                .detailMessage(entityNotFoundException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<APIResultDto> notFoundExceptionHandler(NotFoundException notFoundException) {
        log.error("{}-notFoundExceptionHandler :: NotFoundException: ", getHandler(), notFoundException);
        log.debug(notFoundException.getMessage(), notFoundException);

        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.NOT_FOUND)
                .detailMessage(notFoundException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }

    @ExceptionHandler(value = DuplicateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<APIResultDto> duplicateExceptionHandler(DuplicateException duplicateException) {
        log.error("{}-duplicateExceptionHandler :: DuplicateException: ", getHandler(), duplicateException);
        log.debug(duplicateException.getMessage(), duplicateException);

        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.DUPLICATE_ENTITY)
                .detailMessage(duplicateException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }

    @ExceptionHandler(value = ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<APIResultDto> ValidationExceptionHandler(ValidationException validationException) {
        log.error("{}-ValidationException :: validationException: ", getHandler(), validationException);
        log.debug(validationException.getMessage(), validationException);

        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.VALIDATION_ERROR)
                .detailMessage(validationException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }

    @ExceptionHandler(value = ServiceUnavailableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<APIResultDto> serviceUnavailableExceptionHandler(ServiceUnavailableException serviceUnavailableException) {
        log.error("{}-serviceUnavailableExceptionHandler :: serviceUnavailableException: ", getHandler(), serviceUnavailableException);
        log.debug(serviceUnavailableException.getMessage(), serviceUnavailableException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.INTERNAL_SERVER_ERROR)
                .detailMessage(serviceUnavailableException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<APIResultDto> methodNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
        log.error("{}-methodNotValidExceptionHandler :: ValidationException: ", getHandler(), methodArgumentNotValidException);
        log.debug(methodArgumentNotValidException.getMessage(), methodArgumentNotValidException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.VALIDATION_ERROR)
                .detailMessage(methodArgumentNotValidException.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }

    @ExceptionHandler(value = PageValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<APIResultDto> pageValidationExceptionHandler(PageValidationException pageValidationException) {
        log.error("{}-pageValidationExceptionHandler :: PageValidationException: ", getHandler(), pageValidationException);
        log.debug(pageValidationException.getMessage(), pageValidationException);
        APIResultDto resultDto = new APIResultDtoWithData<>();
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.VALIDATION_ERROR)
                .detailMessage(pageValidationException.getMessage())
                .build());
        return ResponseHandler.handleResponse(resultDto);
    }
}
