package ir.kian.igap.IgapUserProfileChallenge.domain.entity;

import ir.kian.igap.IgapUserProfileChallenge.utis.CellPhoneUtils;
import ir.kian.igap.common.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = Mobile.TABLE_NAME)
@SuperBuilder
public class Mobile extends BaseEntity<UUID> {
    public static final String TABLE_NAME = "mobile_numbers";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String mobileNo;
    private Date lastInquiry;
    private Date lastOtp;

    @OneToOne
    private Person person;

    public void setMobileNo(String mobileNo) {
        this.mobileNo = CellPhoneUtils.toStandard(mobileNo);
    }


}

