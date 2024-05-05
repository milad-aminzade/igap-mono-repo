package ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person;

import ir.kian.igap.common.domain.dto.response.ResponseDto;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PersonIdResponseDto extends ResponseDto {
    private UUID id;
}
