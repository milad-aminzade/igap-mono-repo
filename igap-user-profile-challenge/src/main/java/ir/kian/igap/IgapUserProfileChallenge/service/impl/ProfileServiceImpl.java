package ir.kian.igap.IgapUserProfileChallenge.service.impl;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.profile.CreateProfileRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.profile.CreateProfileResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.profile.ProfileResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Person;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Profile;
import ir.kian.igap.IgapUserProfileChallenge.exception.ProfileNotFoundException;
import ir.kian.igap.IgapUserProfileChallenge.repository.ProfileRepository;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.PersonService;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.ProfileService;
import ir.kian.igap.IgapUserProfileChallenge.transformer.ProfileTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final PersonService personService;
    private final ProfileRepository profileRepository;

    @Override
    public CreateProfileResponseDto createProfile(CreateProfileRequestDto requestDto, String username) {
        Person person = personService.findByUsername(username);
        Profile profile = ProfileTransformer.toPerson(requestDto, person);
        Profile savedProfile = profileRepository.save(profile);
        return ProfileTransformer.toCreateProfileResponseDto(savedProfile);
    }

    @Override
    public ProfileResponseDto getMyProfile(String username) {
        return profileRepository.findByUsername(username)
                .map(ProfileTransformer::toProfileResponseDto)
                .orElseThrow(ProfileNotFoundException::new);
    }
}
