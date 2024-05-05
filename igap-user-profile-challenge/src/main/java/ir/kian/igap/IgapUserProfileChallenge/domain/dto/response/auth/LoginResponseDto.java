package ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.auth;

import ir.kian.igap.common.domain.dto.response.ResponseDto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LoginResponseDto extends ResponseDto {
    private String accessToken;
    private Long expireIn;
    private Long refreshExpiresIn;
    private String refreshToken;
}