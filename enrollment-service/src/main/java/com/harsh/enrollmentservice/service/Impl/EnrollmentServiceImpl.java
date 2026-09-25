package com.harsh.enrollmentservice.service.Impl;

import com.harsh.enrollmentservice.domain.dtos.EnrollmentRequest;
import com.harsh.enrollmentservice.domain.entities.Enrollment;
import com.harsh.enrollmentservice.exception.EnrollmentNotFoundException;
import com.harsh.enrollmentservice.repository.EnrollmentRepository;
import com.harsh.enrollmentservice.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment enroll(EnrollmentRequest request) {
        Enrollment enrollment = new Enrollment();
        enrollment.setFullName(request.getFullName());
        enrollment.setDateOfBirth(request.getDateOfBirth());
        enrollment.setGender(request.getGender());
        enrollment.setAddress(request.getAddress());
        enrollment.setPhoneNumber(request.getPhoneNumber());

        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment getById(UUID id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));
    }
}
