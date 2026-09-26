package com.harsh.identityservice.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "identities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Identity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID enrollmentId;

    @Column(nullable = false, unique = true, length = 12)
    private String identityNumber;

    @Column(nullable = false)
    private LocalDateTime issuedAt;
}
