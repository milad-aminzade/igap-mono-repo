package ir.kian.igap.IgapUserProfileChallenge.transformer;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.mobile.CreateMobileRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.mobile.CreateMobileResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Mobile;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Person;

public class MobileTransformer {
    public static Mobile toMobile(CreateMobileRequestDto requestDto, Person person) {
        return Mobile.builder()
                .mobileNo(requestDto.getMobileNo())
                .person(person)
                .build();
    }

    public static CreateMobileResponseDto toCreateMobileResponse(Mobile mobile) {
        return CreateMobileResponseDto.builder()
                .id(mobile.getId())
                .build();

    }
}
