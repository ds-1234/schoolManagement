package com.project.school.management.exception;

import org.springframework.http.HttpStatus;

import com.project.school.management.enums.ErrorCode;

public class InactiveUserException extends CustomException{

	public InactiveUserException() {
		super(ErrorCode.INACTIVE_USER, HttpStatus.BAD_REQUEST);
	}

}
