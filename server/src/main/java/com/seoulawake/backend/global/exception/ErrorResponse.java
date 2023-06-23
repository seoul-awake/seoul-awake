package com.seoulawake.backend.global.exception;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus httpStatus, String errorMessage) {
}
