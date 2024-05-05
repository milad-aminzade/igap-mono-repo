package ir.kian.igap.IgapUserProfileChallenge.service.interfaces;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.mobile.CreateMobileRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.mobile.CreateMobileResponseDto;

public interface MobileService {
    CreateMobileResponseDto createMobile(CreateMobileRequestDto mobileRequestDto, String username);

}
