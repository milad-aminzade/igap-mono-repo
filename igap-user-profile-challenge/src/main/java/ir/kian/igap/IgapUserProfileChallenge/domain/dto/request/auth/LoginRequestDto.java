package ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.auth;

import ir.kian.igap.common.domain.dto.request.RequestDto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LoginRequestDto extends RequestDto {
    private String username;
    private String password;
}
