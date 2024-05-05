package ir.kian.igap.common.domain.dto.restapi.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import ir.kian.igap.common.domain.dto.response.ResponseDto;
import lombok.*;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@ApiModel(value = "Pagination", description = "Pagination Info")
public class Pagination<TData> extends ResponseDto {
    private Integer pageNo;
    private Integer pageSize;
    private Long totalElement;
    private Integer totalPages;
    @JsonIgnore
    private TData data;
}
