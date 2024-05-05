package ir.kian.igap.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexType {
    MALE(1, "MALE"),
    FEMALE(2, "FEMALE"),
    NOT_VALID_SEX_TYPE(0, "NOT_VALID_SEX_TYPE");
    private Integer value;
    private String name;

    public static SexType fromName(String name) {
        if (name.equals("MALE"))
            return MALE;
        if (name.equals("FEMALE"))
            return FEMALE;
        return NOT_VALID_SEX_TYPE;
    }

    public static SexType fromValue(Integer value) {
        switch (value) {
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            default:
                return NOT_VALID_SEX_TYPE;
        }
    }
}
