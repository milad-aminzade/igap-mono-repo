package ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.address.CreateAddressRequestDto;
import ir.kian.igap.common.domain.dto.request.RequestDto;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreatePersonRequestDto extends RequestDto {
    private String username;

    private String email;

    private String name;

    private String surname;

    private String father;

    private Long birthdate;

    private CreateAddressRequestDto createAddressRequestDto;
}
