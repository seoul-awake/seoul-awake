package com.seoulawake.backend.global.exception.exceptionhandler;

import static com.seoulawake.backend.global.exception.ErrorMessage.*;
import static org.springframework.http.HttpStatus.*;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.seoulawake.backend.global.exception.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(INTERNAL_SERVER_ERROR)
	public ErrorResponse handleUnexpectedException(RuntimeException exception) {
		log.error("UnexpectedException : {}", exception.getMessage());
		return new ErrorResponse(INTERNAL_ERROR.getHttpStatus(), INTERNAL_ERROR.getErrorMessage());
	}
}
