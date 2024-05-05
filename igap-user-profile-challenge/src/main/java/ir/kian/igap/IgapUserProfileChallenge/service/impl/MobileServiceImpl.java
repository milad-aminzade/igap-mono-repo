package ir.kian.igap.IgapUserProfileChallenge.service.impl;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.mobile.CreateMobileRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.mobile.CreateMobileResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Mobile;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Person;
import ir.kian.igap.IgapUserProfileChallenge.repository.MobileRepository;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.MobileService;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.PersonService;
import ir.kian.igap.IgapUserProfileChallenge.transformer.MobileTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MobileServiceImpl implements MobileService {
    private final MobileRepository mobileRepository;
    private final PersonService personService;

    @Override
    public CreateMobileResponseDto createMobile(CreateMobileRequestDto mobileRequestDto, String username) {
        Person person = personService.findByUsername(username);
        Mobile mobile = MobileTransformer.toMobile(mobileRequestDto, person);
        Mobile savedMobile = mobileRepository.save(mobile);
        return MobileTransformer.toCreateMobileResponse(savedMobile);
    }
}
