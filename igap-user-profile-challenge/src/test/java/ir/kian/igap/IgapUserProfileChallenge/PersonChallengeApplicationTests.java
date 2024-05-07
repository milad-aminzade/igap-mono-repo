package ir.kian.igap.IgapUserProfileChallenge;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.address.CreateAddressRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.CreatePersonRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person.PersonIdResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Address;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.City;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Person;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Province;
import ir.kian.igap.IgapUserProfileChallenge.repository.PersonRepository;
import ir.kian.igap.IgapUserProfileChallenge.service.impl.PersonServiceImpl;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.AddressService;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@ActiveProfiles(value = "test")
class PersonChallengeApplicationTests {
    private static final AddressService addressService = Mockito.mock(AddressService.class);

    private static final PersonRepository repository = Mockito.mock(PersonRepository.class);

    private CreatePersonRequestDto createPersonRequestDto;
    private CreateAddressRequestDto createAddressRequestDto;

    private PersonService personService;
    private Address address;
    private City city;

    private Person person;

    private Province province;

    private PersonIdResponseDto personIdResponseDto;

    public PersonChallengeApplicationTests() {
        this.createAddressRequestDto = CreateAddressRequestDto.builder()
                .cityId(1L)
                .latitude("12.25")
                .longitude("25.12")
                .build();
        this.createPersonRequestDto = CreatePersonRequestDto
                .builder()
                .createAddressRequestDto(createAddressRequestDto)
                .email("a@b.com")
                .birthdate(123456789L)
                .name("milad")
                .surname("aminizadeh")
                .father("abbas")
                .username("miladuser")
                .mobile("09376589797")
                .build();
        this.personService = new PersonServiceImpl(addressService, repository);
        this.province = Province.builder()
                .id(1L)
                .title("khozestan")
                .build();
        this.city = City.builder()
                .id(1L)
                .province(province)
                .title("Dezful")
                .build();
        this.address = Address.builder()
                .id(UUID.fromString("560e8400-e29b-41d4-a716-446655440000"))
                .city(city)
                .location("tehran shaqayeq")
                .latitude("12.25")
                .longitude("25.12")
                .build();
        this.person = Person.builder()
                .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))
                .address(address)
                .email("a@b.com")
                .birthdate(123456789L)
                .name("milad")
                .surname("aminizadeh")
                .father("abbas")
                .username("miladuser")
                .mobile("09376589797")
                .isEnabled(false)
                .build();
        this.personIdResponseDto
                = PersonIdResponseDto.builder()
                .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))
                .build();
    }

    @Test
    public void createPersonTest() {
        Mockito.when(addressService.createAddress(createAddressRequestDto))
                .thenReturn(address);
        Mockito.when(repository.save(any()))
                .thenReturn(person);
        final PersonIdResponseDto returnedCreatedPerson = personService.createPerson("guest", createPersonRequestDto);
        Assertions.assertEquals(personIdResponseDto.getId(), returnedCreatedPerson.getId());
        Mockito.verify(addressService).createAddress(createAddressRequestDto);
    }
}
