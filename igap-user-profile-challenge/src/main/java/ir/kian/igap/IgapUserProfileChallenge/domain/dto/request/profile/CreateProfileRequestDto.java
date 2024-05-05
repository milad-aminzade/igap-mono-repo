package ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.profile;

import ir.kian.igap.common.domain.dto.request.RequestDto;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateProfileRequestDto extends RequestDto {
    private String bio;
    private String picturePath;
}
