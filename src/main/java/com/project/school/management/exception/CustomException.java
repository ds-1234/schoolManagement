package com.project.school.management.exception;

import org.springframework.http.HttpStatus;

import com.project.school.management.enums.ErrorCode;

public abstract class CustomException extends RuntimeException{
	

	private final ErrorCode errorCode;
	
	private final HttpStatus httpStatus;
	
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public CustomException(ErrorCode error, HttpStatus statusCode) {
		super(String.valueOf(error));
		this.errorCode = error;
		this.httpStatus = statusCode;
		
	}

}
