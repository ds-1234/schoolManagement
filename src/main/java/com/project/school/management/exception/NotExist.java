package com.project.school.management.exception;

import org.springframework.http.HttpStatus;

import com.project.school.management.enums.ErrorCode;

public class NotExist extends CustomException {

	final String message;

	public NotExist(String message) {
		super(ErrorCode.DATA_NOT_EXIST, HttpStatus.UNAUTHORIZED);
		this.message = message;
	}

	public NotExist() {
		super(ErrorCode.DATA_NOT_EXIST, HttpStatus.UNAUTHORIZED);
		this.message = "";
	}

}
