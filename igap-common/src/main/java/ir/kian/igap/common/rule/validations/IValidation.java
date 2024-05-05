package ir.kian.igap.common.rule.validations;

import jakarta.validation.ValidationException;

public interface IValidation<ValidationRequest> {
    boolean validate(ValidationRequest t) throws ValidationException;
}
