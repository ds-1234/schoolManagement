package com.project.school.management.exception;

import org.springframework.http.HttpStatus;

import com.project.school.management.enums.ErrorCode;

public class InvalidArgumentException extends CustomException {

	final String message;

	public InvalidArgumentException() {
		super(ErrorCode.INVALID_ARGUMENT, HttpStatus.BAD_REQUEST);
		this.message = "";
	}

	public InvalidArgumentException(String message) {
		super(ErrorCode.INVALID_ARGUMENT, HttpStatus.BAD_REQUEST);
		this.message = message;
	}

}
