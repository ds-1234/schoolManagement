package com.project.school.management.exception;

import org.springframework.http.HttpStatus;

import com.project.school.management.enums.ErrorCode;

public class UserAlreadyExistException extends CustomException{
	
	public UserAlreadyExistException() {
		super(ErrorCode.USER_ALREADY_EXIST, HttpStatus.UNAUTHORIZED);
	}


}
