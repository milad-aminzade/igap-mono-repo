package ir.kian.igap.common.domain.dto.restapi.result.enumstatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum BaseStatusEnum {
    DONE(200, "DONE", true),
    DUPLICATE_ENTITY(409, "DUPLICATE_ENTITY", false),
    FORBIDDEN(403, "FORBIDDEN", false),
    NOT_FOUND(404, "NOT_FOUND", false),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR", false),
    VALIDATION_ERROR(400, "VALIDATION_ERROR", false),
    NOT_ACCEPTABLE(406, "NOT_ACCEPTABLE", false),
    UN_AUTHORIZED(401, "UN_AUTHORIZED", false),
    PAYLOAD_TOO_LARGE(413,"PAYLOAD_TOO_LARGE",false),
    FAILED_DEPENDENCY(424, "FAILED_DEPENDENCY", false);

    private int code;
    private String message;
    private Boolean success;

}
