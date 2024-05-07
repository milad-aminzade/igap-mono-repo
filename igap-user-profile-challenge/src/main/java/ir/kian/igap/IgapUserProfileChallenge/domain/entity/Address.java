package ir.kian.igap.IgapUserProfileChallenge.domain.entity;

import ir.kian.igap.common.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = Address.TABLE_NAME)
public class Address extends BaseEntity<UUID> {
    public static final String TABLE_NAME = "address";
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(targetEntity = City.class)
    private City city;
    private String location;
    private String latitude;
    private String longitude;

}