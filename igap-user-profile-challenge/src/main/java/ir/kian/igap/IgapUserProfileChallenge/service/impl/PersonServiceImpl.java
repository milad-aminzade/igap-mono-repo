package ir.kian.igap.IgapUserProfileChallenge.service.impl;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.CreatePersonRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.PersonPageRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person.PersonIdResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person.PersonResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Address;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Person;
import ir.kian.igap.IgapUserProfileChallenge.exception.PersonNotFoundException;
import ir.kian.igap.IgapUserProfileChallenge.repository.PersonRepository;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.AddressService;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.PersonService;
import ir.kian.igap.IgapUserProfileChallenge.transformer.PersonTransformer;
import ir.kian.igap.IgapUserProfileChallenge.utis.PageRequestUtil;
import ir.kian.igap.IgapUserProfileChallenge.utis.PageRequestValidation;
import ir.kian.igap.IgapUserProfileChallenge.utis.SpecificationUtils;
import ir.kian.igap.common.domain.dto.restapi.result.Pagination;
import ir.kian.igap.common.utils.PaginationUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final AddressService addressService;
    private final PersonRepository repository;

    @Override
    public PersonIdResponseDto createPerson(String username, CreatePersonRequestDto createPersonRequestDto) {
        Address address = addressService.createAddress(createPersonRequestDto.getCreateAddressRequestDto());
        Person person = PersonTransformer.toPerson(createPersonRequestDto, address);
        Person savedPerson = repository.save(person);
        return PersonTransformer.toCreatePersonResponseDto(savedPerson);
    }

    @Transactional
    @Override
    public PersonIdResponseDto enablePerson(String username, UUID personId) {
        repository.enablePerson(personId);
        return PersonTransformer.personIdResponseDto(personId);
    }

    @Override
    @Cacheable(value = "Person", key = "#id")
    public Person findPerson(UUID id) {
        return repository.findById(id)
                .orElseThrow(PersonNotFoundException::new);
    }

    @Override
    @Cacheable(value = "Person", key = "#username")
    public Person findByUsername(String username) {
        return repository.findPersonByUsername(username)
                .orElseThrow(PersonNotFoundException::new);
    }

    @Override
    @Cacheable(value = "PersonResponseDto", key = "#id")
    public PersonResponseDto getById(String username, UUID id) {
        Person person = findPerson(id);
        return PersonTransformer.toPersonResponseDto(person);
    }

    @Override
    public Pagination<List<PersonResponseDto>> getPersons(String username, PersonPageRequestDto requestDto) {
        PageRequestValidation.validate(requestDto);
        PageRequest pageRequest = PageRequestUtil.toPageRequest(requestDto);
        Specification<Person> vehicleTypeSpecification = SpecificationUtils.vehicleTypeSpecification(requestDto);
        Page<Person> personPage = repository.findAll(vehicleTypeSpecification, pageRequest);
        List<PersonResponseDto> personResponseDtos = PersonTransformer.personResponseDtos(personPage.stream());
        return PaginationUtil.toPaginationWithAddOneToPageNoDto(personResponseDtos,
                personPage.getTotalElements(), pageRequest.getPageNumber(), pageRequest.getPageSize(), personPage.getTotalPages());
    }
}
