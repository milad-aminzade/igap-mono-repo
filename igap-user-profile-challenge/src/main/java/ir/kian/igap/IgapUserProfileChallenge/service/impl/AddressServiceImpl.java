package ir.kian.igap.IgapUserProfileChallenge.service.impl;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.address.CreateAddressRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Address;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.City;
import ir.kian.igap.IgapUserProfileChallenge.repository.AddressRepository;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.AddressService;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.CityService;
import ir.kian.igap.IgapUserProfileChallenge.transformer.AddressTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final CityService cityService;
    private final AddressRepository addressRepository;

    @Override
    public Address createAddress(CreateAddressRequestDto addressRequestDto) {
        City city = cityService.getCity(addressRequestDto.getCityId());
        Address address = AddressTransformer.toAddress(addressRequestDto, city);
        return addressRepository.save(address);
    }
}
