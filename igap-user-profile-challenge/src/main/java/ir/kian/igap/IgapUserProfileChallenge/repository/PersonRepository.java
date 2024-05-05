package ir.kian.igap.IgapUserProfileChallenge.repository;

import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID>, JpaSpecificationExecutor<Person> {
    Optional<Person> findPersonByUsername(String username);


    @Modifying
    @Query("update Person p set p.isEnabled=TRUE where p.id=:id")
    void enablePerson(@Param("id") UUID id);
}
