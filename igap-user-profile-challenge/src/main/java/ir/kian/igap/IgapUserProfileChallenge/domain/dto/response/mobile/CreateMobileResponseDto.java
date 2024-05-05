package ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.mobile;

import ir.kian.igap.common.domain.dto.response.ResponseDto;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateMobileResponseDto extends ResponseDto {
    private UUID id;
}
