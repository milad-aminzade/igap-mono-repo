package ir.kian.igap.IgapUserProfileChallenge.service.interfaces;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.address.CreateAddressRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Address;

public interface AddressService {
    Address createAddress(CreateAddressRequestDto addressRequestDto);

}
