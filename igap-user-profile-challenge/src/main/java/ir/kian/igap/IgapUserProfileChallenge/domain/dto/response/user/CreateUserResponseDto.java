package ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.user;

import ir.kian.igap.common.domain.dto.response.ResponseDto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateUserResponseDto extends ResponseDto {
    private String username;
}
