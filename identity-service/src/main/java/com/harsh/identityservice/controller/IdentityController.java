package com.harsh.identityservice.controller;

import com.harsh.identityservice.domain.dtos.IdentityRequest;
import com.harsh.identityservice.domain.entities.Identity;
import com.harsh.identityservice.service.IdentityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/identities")
@RequiredArgsConstructor
public class IdentityController {

    private final IdentityService identityService;

    @PostMapping
    public ResponseEntity<Identity> generate(
            @Valid @RequestBody IdentityRequest request
            ) {
        return ResponseEntity.ok(identityService.generate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Identity> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(identityService.getById(id));
    }
}
