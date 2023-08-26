package com.project.school.management.exception;

import org.springframework.http.HttpStatus;

import com.project.school.management.enums.ErrorCode;

public class InvalidRoleException extends CustomException{
	
	public InvalidRoleException() {
		super(ErrorCode.ROLE_DOES_NOT_EXIST, HttpStatus.UNAUTHORIZED);
	}

}
