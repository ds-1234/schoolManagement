package com.project.school.management.exception;

import org.springframework.http.HttpStatus;

import com.project.school.management.enums.ErrorCode;

public class InvalidPhoneException extends CustomException{

	public InvalidPhoneException(ErrorCode error, HttpStatus statusCode) {
		super(error.INVALID_PHONE_NUMBER, statusCode.BAD_REQUEST);
	}

}
