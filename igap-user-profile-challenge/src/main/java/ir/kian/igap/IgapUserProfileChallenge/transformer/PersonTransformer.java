package ir.kian.igap.IgapUserProfileChallenge.transformer;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.CreatePersonRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person.CreatePersonResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person.PersonResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Address;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Person;

import java.util.List;
import java.util.stream.Stream;

public class PersonTransformer {

    public static List<PersonResponseDto> personResponseDtos(Stream<Person> personStream) {
        return personStream
                .map(PersonTransformer::toPersonResponseDto)
                .toList();
    }

    public static PersonResponseDto toPersonResponseDto(Person person) {
        return PersonResponseDto.builder()
                .id(person.getId())
                .name(person.getName())
                .surname(person.getSurname())
                .father(person.getFather())
                .email(person.getEmail())
                .mobile(person.getMobile() != null ? person.getMobile().getMobileNo() : null)
                .address(person.getAddress() != null ? person.getAddress().getLocation() : null)
                .city(person.getAddress() != null ? person.getAddress().getCity() != null ? person.getAddress().getCity().getTitle() : null : null)
                .province(person.getAddress() != null ?
                        person.getAddress().getCity() != null ?
                                person.getAddress().getCity().getProvince() != null ?
                                        person.getAddress().getCity().getProvince().getTitle() : null : null : null)
                .id(person.getId())
                .build();
    }

    public static Person toPerson(CreatePersonRequestDto requestDto, Address address) {
        return Person.builder()
                .name(requestDto.getName())
                .surname(requestDto.getSurname())
                .father(requestDto.getFather())
                .birthdate(requestDto.getBirthdate())
                .email(requestDto.getEmail())
                .address(address)
                .build();
    }

    public static CreatePersonResponseDto toCreatePersonResponseDto(Person person) {
        return CreatePersonResponseDto.builder()
                .id(person.getId())
                .build();
    }

    private static String toAddress(Address address) {
        return String.format("%S - %S", address.getCity() != null ? address.getCity().getTitle() : null, address.getLocation());
    }

//    public static PersonResponseDto toPersonResponseDto(Person person) {
//        return PersonResponseDto.builder()
//                .id(person.getId())
//                .name(person.getName())
//                .surname(person.getSurname())
//                .father(person.getFather())
//                .mobile(person.getMobile() != null ? person.getMobile().getMobileNo() : null)
//                .address(person.getAddress() != null ? toAddress(person.getAddress()) : null)
//                .email(person.getEmail())
//                .build();
//    }
}
