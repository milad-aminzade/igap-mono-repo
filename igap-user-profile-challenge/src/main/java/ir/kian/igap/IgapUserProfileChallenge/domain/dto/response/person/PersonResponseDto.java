package ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person;

import ir.kian.igap.common.domain.dto.response.ResponseDto;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PersonResponseDto extends ResponseDto {
    private UUID id;

    private String email;

    private String name;

    private String surname;

    private String father;

    private Long birthdate;

    private String city;

    private String province;

    private String address;

    private String mobile;

    private String username;

    private Boolean isEnabled;
}
