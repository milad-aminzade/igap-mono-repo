package ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.address;

import ir.kian.igap.common.domain.dto.request.RequestDto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateAddressRequestDto extends RequestDto {
    private String location;
    private String latitude;
    private String longitude;
    private Long cityId;
}
