package com.seoulawake.backend.global.exception.exceptionhandler;

import com.seoulawake.backend.global.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.seoulawake.backend.global.exception.ErrorMessage.INTERNAL_ERROR;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnexpectedException(Exception e) {
        log.error("UnexpectedException : {}", e.getMessage());
        return new ErrorResponse(INTERNAL_ERROR.getHttpStatus(), INTERNAL_ERROR.getErrorMessage());
    }
}
