package ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.otp;

import ir.kian.igap.common.domain.dto.request.RequestDto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OTPRequestDto extends RequestDto {
    private String cellphone;
}
