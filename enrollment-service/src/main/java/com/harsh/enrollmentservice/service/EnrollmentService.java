package com.harsh.enrollmentservice.service;

import com.harsh.enrollmentservice.domain.dtos.EnrollmentRequest;
import com.harsh.enrollmentservice.domain.entities.Enrollment;

import java.util.UUID;

public interface EnrollmentService {

    Enrollment enroll(EnrollmentRequest request);

    Enrollment getById(UUID id);
}
