package ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person;

import ir.kian.igap.common.domain.dto.request.BasePaginationRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonPageRequestDto extends BasePaginationRequestDto {
    private String username;
    private String email;
    private String name;
    private String surname;
    private String city;
    private String province;
    private String mobile;
}
