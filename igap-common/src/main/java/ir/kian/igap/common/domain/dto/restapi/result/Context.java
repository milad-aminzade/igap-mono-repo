package ir.kian.igap.common.domain.dto.restapi.result;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import ir.kian.igap.common.domain.dto.response.ResponseDto;
import ir.kian.igap.common.domain.dto.restapi.result.enumstatus.BaseStatusEnum;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@ApiModel(value = "Response Context", description = "Context of response")
public class Context extends ResponseDto {
    private Pagination<?> pagination;
    private BaseStatusEnum statusEnum;
    private String detailMessage;
}
