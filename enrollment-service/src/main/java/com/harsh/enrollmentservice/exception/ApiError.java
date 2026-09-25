package com.harsh.enrollmentservice.exception;

import java.time.Instant;

public record ApiError(int status, String message, Instant timestamp) {}
