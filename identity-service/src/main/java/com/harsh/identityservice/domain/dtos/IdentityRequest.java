package com.harsh.identityservice.domain.dtos;

import jakarta.annotation.Nonnull;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdentityRequest {

    @Nonnull
    private UUID enrollmentId;
}
