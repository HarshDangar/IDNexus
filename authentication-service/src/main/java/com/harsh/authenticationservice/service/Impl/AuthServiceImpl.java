package com.harsh.authenticationservice.service.Impl;

import com.harsh.authenticationservice.domain.dtos.RegisterRequest;
import com.harsh.authenticationservice.domain.entities.AuthCredential;
import com.harsh.authenticationservice.domain.entities.AuthRole;
import com.harsh.authenticationservice.exception.UserAlreadyExistsException;
import com.harsh.authenticationservice.repository.AuthCredentialRepository;
import com.harsh.authenticationservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthCredentialRepository authCredentialRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthCredential register(RegisterRequest request) {
        if (authCredentialRepository.existsByUserName(request.getUserName())) {
            throw new UserAlreadyExistsException(request.getUserName());
        }

        AuthCredential credential = new AuthCredential();
        credential.setEnrollmentId(request.getEnrollmentId());
        credential.setUserName(request.getUserName());
        credential.setPassword(passwordEncoder.encode(request.getPassword()));
        credential.setRole(AuthRole.USER);

        return authCredentialRepository.save(credential);
    }
}
