package ir.kian.igap.IgapUserProfileChallenge.service.interfaces;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.CreatePersonRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.PersonPageRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person.PersonIdResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person.PersonResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Person;
import ir.kian.igap.common.domain.dto.restapi.result.Pagination;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    PersonIdResponseDto createPerson(String username, CreatePersonRequestDto createPersonRequestDto);

    PersonIdResponseDto enablePerson(String username, UUID personId);

    Person findPerson(UUID id);

    Person findByUsername(String username);

    PersonResponseDto getById(String username, UUID id);

    Pagination<List<PersonResponseDto>> getPersons(String username, PersonPageRequestDto requestDto);


}
