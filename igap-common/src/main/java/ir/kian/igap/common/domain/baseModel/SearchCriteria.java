package ir.kian.igap.common.domain.baseModel;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
