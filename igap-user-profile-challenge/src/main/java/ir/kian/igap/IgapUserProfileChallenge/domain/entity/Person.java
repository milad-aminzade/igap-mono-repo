package ir.kian.igap.IgapUserProfileChallenge.domain.entity;

import ir.kian.igap.common.domain.entity.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = Person.TABLE_NAME)
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity<UUID> {
    public static final String TABLE_NAME = "person";
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;

    private String email;

    private String name;

    private String surname;

    @Nullable
    @ManyToOne(targetEntity = Address.class)
    private Address address;

    private String father;

    private Long birthdate;

    @OneToOne
    private Mobile mobile;
}
