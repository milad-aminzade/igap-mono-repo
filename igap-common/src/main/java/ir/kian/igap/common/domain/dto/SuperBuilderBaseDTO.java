package ir.kian.igap.common.domain.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

@Data
@SuperBuilder
public abstract class SuperBuilderBaseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8664710824576476467L;
}
