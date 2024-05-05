package ir.kian.igap.IgapUserProfileChallenge.domain.entity;

import ir.kian.igap.common.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = City.TABLE_NAME)
public class City extends BaseEntity<Long> {
    public static final String TABLE_NAME = "City";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME + "_seq")
    @SequenceGenerator(name = TABLE_NAME + "_seq", sequenceName = TABLE_NAME + "_seq")
    private Long id;

    private String title;

    @ManyToOne(targetEntity = Province.class)
    private Province province;

}
