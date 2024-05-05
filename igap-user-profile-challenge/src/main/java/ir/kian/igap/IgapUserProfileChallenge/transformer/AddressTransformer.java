package ir.kian.igap.IgapUserProfileChallenge.transformer;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.address.CreateAddressRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Address;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.City;

public class AddressTransformer {

    public static Address toAddress(CreateAddressRequestDto requestDto, City city) {
        return Address.builder()
                .location(requestDto.getLocation())
                .latitude(requestDto.getLatitude())
                .longitude(requestDto.getLongitude())
                .city(city)
                .build();
    }
}
