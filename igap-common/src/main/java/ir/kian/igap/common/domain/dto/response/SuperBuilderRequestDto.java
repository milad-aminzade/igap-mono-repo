package ir.kian.igap.common.domain.dto.response;

import ir.kian.igap.common.domain.dto.SuperBuilderBaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class SuperBuilderRequestDto extends SuperBuilderBaseDTO {
}
