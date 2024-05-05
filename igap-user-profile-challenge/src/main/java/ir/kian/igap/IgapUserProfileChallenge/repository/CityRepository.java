package ir.kian.igap.IgapUserProfileChallenge.repository;

import ir.kian.igap.IgapUserProfileChallenge.domain.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {
}
