package com.harsh.authenticationservice.service.Impl;

import com.harsh.authenticationservice.domain.dtos.AuthResponse;
import com.harsh.authenticationservice.domain.dtos.LoginRequest;
import com.harsh.authenticationservice.domain.dtos.RegisterRequest;
import com.harsh.authenticationservice.domain.entities.AuthCredential;
import com.harsh.authenticationservice.domain.entities.AuthRole;
import com.harsh.authenticationservice.exception.InvalidCredentialsException;
import com.harsh.authenticationservice.exception.UserAlreadyExistsException;
import com.harsh.authenticationservice.repository.AuthCredentialRepository;
import com.harsh.authenticationservice.security.JwtService;
import com.harsh.authenticationservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthCredentialRepository authCredentialRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

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

    @Override
    public AuthResponse login(LoginRequest request) {
        AuthCredential credential = authCredentialRepository.findByUserName(request.getUserName())
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(request.getPassword(), credential.getPassword())) {
            throw new InvalidCredentialsException();
        }

        String token = jwtService.generateToken(
                credential.getUserName(),
                Map.of(
                        "enrollmentId", credential.getEnrollmentId().toString(),
                        "role", credential.getRole().name()
                )
        );

        return AuthResponse.builder()
                .token(token)
                .tokenType("Bearer")
                .expiresInMs(jwtService.getExpirationMs())
                .build();
    }

    @Override
    public boolean validate(String token) {
        return jwtService.isTokenValid(token);
    }
}
