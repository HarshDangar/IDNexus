package com.harsh.authenticationservice.service;

import com.harsh.authenticationservice.domain.dtos.RegisterRequest;
import com.harsh.authenticationservice.domain.entities.AuthCredential;

public interface AuthService {

    AuthCredential register(RegisterRequest request);
}
