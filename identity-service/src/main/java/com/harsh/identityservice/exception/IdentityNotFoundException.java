package com.harsh.identityservice.exception;

import java.util.UUID;

public class IdentityNotFoundException extends RuntimeException {
    public IdentityNotFoundException(UUID id) {
        super("Identity not found: " + id);
    }
}
