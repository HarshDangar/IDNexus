package com.harsh.identityservice.repository;

import com.harsh.identityservice.domain.entities.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IdentityRepository extends JpaRepository<Identity, UUID> {
    Optional<Identity> findByEnrollmentId(UUID enrollmentId);
}
