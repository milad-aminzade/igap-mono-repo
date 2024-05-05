package ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.mobile;

import ir.kian.igap.common.domain.dto.request.RequestDto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateMobileRequestDto extends RequestDto {
    private String mobileNo;
}
