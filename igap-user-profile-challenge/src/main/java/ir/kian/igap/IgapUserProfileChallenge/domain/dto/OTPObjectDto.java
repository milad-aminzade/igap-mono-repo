package ir.kian.igap.IgapUserProfileChallenge.domain.dto;

import ir.kian.igap.common.domain.dto.BaseDTO;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OTPObjectDto extends BaseDTO {
    private String trackingCode;
    private String cellphone;
    private String otpAnswer;
}
