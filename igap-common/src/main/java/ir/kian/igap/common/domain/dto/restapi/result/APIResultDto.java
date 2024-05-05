package ir.kian.igap.common.domain.dto.restapi.result;

import io.swagger.annotations.ApiModel;
import ir.kian.igap.common.domain.dto.response.ResponseDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Response with data", description = "Response with data")
public class APIResultDto extends ResponseDto {
    private Context context;
}
