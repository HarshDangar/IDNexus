package com.harsh.enrollmentservice.controller;

import com.harsh.enrollmentservice.domain.dtos.EnrollmentRequest;
import com.harsh.enrollmentservice.domain.entities.Enrollment;
import com.harsh.enrollmentservice.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<Enrollment> enroll(
            @Valid @RequestBody EnrollmentRequest request
            ) {
        return ResponseEntity.ok(enrollmentService.enroll(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(enrollmentService.getById(id));
    }
}
