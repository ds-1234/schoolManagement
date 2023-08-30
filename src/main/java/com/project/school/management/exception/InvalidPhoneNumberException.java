package com.project.school.management.exception;

import org.springframework.http.HttpStatus;

import com.project.school.management.enums.ErrorCode;

public class InvalidPhoneNumberException extends CustomException {

	public InvalidPhoneNumberException() {
		super(ErrorCode.INVALID_PHONE_NUMBER, HttpStatus.BAD_REQUEST);
	}

}
