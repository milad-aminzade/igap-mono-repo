package ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.address;

import ir.kian.igap.common.domain.dto.response.ResponseDto;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddressResponseDto extends ResponseDto {
    private UUID id;
    private String city;
    private String location;
    private String latitude;
    private String longitude;
}
