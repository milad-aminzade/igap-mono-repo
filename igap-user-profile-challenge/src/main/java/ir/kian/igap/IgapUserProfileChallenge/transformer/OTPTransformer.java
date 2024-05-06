package ir.kian.igap.IgapUserProfileChallenge.transformer;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.OTPObjectDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.otp.OTPResponseDto;

public class OTPTransformer {
    public static OTPResponseDto toOTPResponseDto(OTPObjectDto otpTrackingCode) {
        return OTPResponseDto.builder().trackingCode(otpTrackingCode.getTrackingCode()).build();
    }

    public static OTPObjectDto toOTPObjectDto(String otpTrackingCode, String cellphone,String otpAnswer) {
        return OTPObjectDto.builder()
                .cellphone(cellphone)
                .trackingCode(otpTrackingCode)
                .otpAnswer(otpAnswer)
                .build();
    }
}
