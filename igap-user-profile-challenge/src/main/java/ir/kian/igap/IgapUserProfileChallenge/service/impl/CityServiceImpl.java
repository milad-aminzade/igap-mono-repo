package ir.kian.igap.IgapUserProfileChallenge.service.impl;

import ir.kian.igap.IgapUserProfileChallenge.domain.entity.City;
import ir.kian.igap.IgapUserProfileChallenge.exception.CityNotFoundException;
import ir.kian.igap.IgapUserProfileChallenge.repository.CityRepository;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    @Override
    public City getCity(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(CityNotFoundException::new);
    }
}
