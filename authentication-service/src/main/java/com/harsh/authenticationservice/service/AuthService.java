package com.harsh.authenticationservice.service;

import com.harsh.authenticationservice.domain.dtos.AuthResponse;
import com.harsh.authenticationservice.domain.dtos.LoginRequest;
import com.harsh.authenticationservice.domain.dtos.RegisterRequest;
import com.harsh.authenticationservice.domain.entities.AuthCredential;

public interface AuthService {

    AuthCredential register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    boolean validate(String token);
}
