package ir.kian.igap.IgapUserProfileChallenge.repository;

import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface MobileRepository extends JpaRepository<Mobile, UUID> , JpaSpecificationExecutor<Mobile> {
}
