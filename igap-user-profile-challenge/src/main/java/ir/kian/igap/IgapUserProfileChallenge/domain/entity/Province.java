package ir.kian.igap.IgapUserProfileChallenge.domain.entity;

import ir.kian.igap.common.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = Province.TABLE_NAME)
public class Province extends BaseEntity<Long> {
    public static final String TABLE_NAME = "Province";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME + "_seq")
    @SequenceGenerator(name = TABLE_NAME + "_seq", sequenceName = TABLE_NAME + "_seq")
    private Long id;

    private String title;

    @OneToMany(targetEntity = City.class, mappedBy = "province", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<City> cities;

}

