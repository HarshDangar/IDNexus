package com.harsh.identityservice.exception;

import java.util.UUID;

public class IdentityAlreadyExistsException extends RuntimeException {
    public IdentityAlreadyExistsException(UUID enrollmentId) {
        super("Identity already exists for enrollment: " + enrollmentId);
    }
}
