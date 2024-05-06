package ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.otp;

import ir.kian.igap.common.domain.dto.response.ResponseDto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OTPResponseDto extends ResponseDto {
    private String trackingCode;
}
