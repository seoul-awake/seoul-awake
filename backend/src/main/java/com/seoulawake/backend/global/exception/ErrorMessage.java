package com.seoulawake.backend.global.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorMessage {
	// 500
	INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다. 관리자에게 문의주세요.");

	ErrorMessage(HttpStatus httpStatus, String errorMessage) {
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
	}

	private final HttpStatus httpStatus;
	private final String errorMessage;
}
