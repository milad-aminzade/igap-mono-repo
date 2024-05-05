package ir.kian.igap.common.domain.dto.response;

import ir.kian.igap.common.domain.dto.SuperBuilderBaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public abstract class SuperBuilderResponseDto extends SuperBuilderBaseDTO {
}
