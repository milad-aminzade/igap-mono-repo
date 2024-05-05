package ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.profile;

import ir.kian.igap.common.domain.dto.response.ResponseDto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProfileResponseDto extends ResponseDto {
    private String bio;
    private String picturePath;
}
