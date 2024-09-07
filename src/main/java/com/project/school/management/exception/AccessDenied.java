package com.project.school.management.exception;

import org.springframework.http.HttpStatus;

import com.project.school.management.enums.ErrorCode;

public class AccessDenied extends CustomException {

	public final String message;

	public AccessDenied() {
		super(ErrorCode.ACCED_DENIED, HttpStatus.UNAUTHORIZED);
		this.message = "";
	}

	public AccessDenied(String message) {
		super(ErrorCode.ACCED_DENIED, HttpStatus.UNAUTHORIZED, message);
		this.message = message;
	}

}
