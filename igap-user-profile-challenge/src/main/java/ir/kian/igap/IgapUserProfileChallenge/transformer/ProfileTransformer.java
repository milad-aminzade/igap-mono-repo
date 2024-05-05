package ir.kian.igap.IgapUserProfileChallenge.transformer;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.profile.CreateProfileRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.profile.CreateProfileResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.profile.ProfileResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Person;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Profile;

public class ProfileTransformer {
    public static Profile toPerson(CreateProfileRequestDto requestDto, Person person) {
        return Profile.builder()
                .person(person)
                .bio(requestDto.getBio())
                .picturePath(requestDto.getPicturePath())
                .build();
    }

    public static CreateProfileResponseDto toCreateProfileResponseDto(Profile profile) {
        return CreateProfileResponseDto.builder()
                .id(profile.getId())
                .build();
    }

    public static ProfileResponseDto toProfileResponseDto(Profile profile){
        return ProfileResponseDto.builder()
                .bio(profile.getBio())
                .picturePath(profile.getPicturePath())
                .build();
    }
}
