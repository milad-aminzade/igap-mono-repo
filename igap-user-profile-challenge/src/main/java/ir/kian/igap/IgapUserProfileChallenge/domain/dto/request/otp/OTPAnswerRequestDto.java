package ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.otp;

import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OTPAnswerRequestDto extends OTPRequestDto {
    private String trackingCode;
    private String answer;

    @Builder(builderMethodName = "OTPAnswerRequestDtoBuilder")
    public OTPAnswerRequestDto(String cellphone, String trackingCode, String answer) {
        super(cellphone);
        this.trackingCode = trackingCode;
        this.answer = answer;
    }
}
