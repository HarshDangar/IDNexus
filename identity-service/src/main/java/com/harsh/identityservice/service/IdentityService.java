package com.harsh.identityservice.service;

import com.harsh.identityservice.domain.dtos.IdentityRequest;
import com.harsh.identityservice.domain.entities.Identity;

import java.util.UUID;

public interface IdentityService {

    Identity generate(IdentityRequest request);

    Identity getById(UUID id);
}
