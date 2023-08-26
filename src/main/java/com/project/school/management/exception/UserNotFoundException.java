package com.project.school.management.exception;

import org.springframework.http.HttpStatus;

import com.project.school.management.enums.ErrorCode;

public class UserNotFoundException extends CustomException {

	public UserNotFoundException() {
		super(ErrorCode.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
	}

}
