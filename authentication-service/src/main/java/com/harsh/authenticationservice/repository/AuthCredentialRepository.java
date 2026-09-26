package com.harsh.authenticationservice.repository;

import com.harsh.authenticationservice.domain.entities.AuthCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthCredentialRepository extends JpaRepository<AuthCredential, UUID> {
    boolean existsByUserName(String userName);

    Optional<AuthCredential> findByUserName(String userName);
}
