package ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.user;

import ir.kian.igap.common.domain.dto.request.RequestDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateUserRequestDto extends RequestDto {
    @NotBlank(message = "user name can't be blank")
    @NotEmpty(message = "username can not empty")
    @Min(value = 8,message = "minimum size of username is 8 character")
    private String username;
    @Min(value = 8,message = "minimum size of password is 8 character")
    @Max(value = 16,message = "maximum size of password is 16 character" )
    private String password;
    private String rePassword;

}
