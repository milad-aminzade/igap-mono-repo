package ir.kian.igap.IgapUserProfileChallenge.domain.entity;

import ir.kian.igap.common.domain.entity.BaseEntity;
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
public class Profile extends BaseEntity<UUID> {
    public static final String TABLE_NAME = "profile";
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String bio;
    private String picturePath;
    @ManyToOne(targetEntity = Person.class)
    private Person person;
}
