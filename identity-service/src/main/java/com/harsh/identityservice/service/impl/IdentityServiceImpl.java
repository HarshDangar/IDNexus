package com.harsh.identityservice.service.impl;

import com.harsh.identityservice.domain.dtos.IdentityRequest;
import com.harsh.identityservice.domain.entities.Identity;
import com.harsh.identityservice.exception.IdentityAlreadyExistsException;
import com.harsh.identityservice.exception.IdentityNotFoundException;
import com.harsh.identityservice.repository.IdentityRepository;
import com.harsh.identityservice.service.IdentityService;
import com.harsh.identityservice.util.IdentityNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IdentityServiceImpl implements IdentityService {

    private final IdentityRepository identityRepository;

    public Identity generate(IdentityRequest request) {
        identityRepository.findByEnrollmentId(request.getEnrollmentId())
                .ifPresent(i -> { throw new IdentityAlreadyExistsException(request.getEnrollmentId());});

        Identity identity = new Identity();
        identity.setEnrollmentId(request.getEnrollmentId());
        identity.setIdentityNumber(IdentityNumberGenerator.generate());
        identity.setIssuedAt(LocalDateTime.now());

        return identityRepository.save(identity);
    }

    public Identity getById(UUID id) {
        return identityRepository.findById(id)
                .orElseThrow(() -> new IdentityNotFoundException(id));
    }
}
