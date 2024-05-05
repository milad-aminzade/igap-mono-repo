package ir.kian.igap.common.domain.dto.restapi.result;

import io.swagger.annotations.ApiModel;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Response with data", description = "Response with data")
public class APIResultDtoWithData<TData extends Object> extends APIResultDto {
    private TData data;

    @Builder(builderMethodName = "childBuilder")
    public APIResultDtoWithData(Context context, TData data) {
        super(context);
        this.data = data;
    }
}