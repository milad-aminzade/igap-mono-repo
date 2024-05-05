package ir.kian.igap.IgapUserProfileChallenge.repository;

import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ProvinceRepository extends JpaRepository<Province, UUID>, JpaSpecificationExecutor<Province> {
}
