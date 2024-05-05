package ir.kian.igap.IgapUserProfileChallenge.service.interfaces;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.profile.CreateProfileRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.profile.CreateProfileResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.profile.ProfileResponseDto;

public interface ProfileService {
    CreateProfileResponseDto createProfile(CreateProfileRequestDto requestDto, String username);

    ProfileResponseDto getMyProfile(String username);
}
