package com.project.school.management.exception;

import org.springframework.http.HttpStatus;

import com.project.school.management.enums.ErrorCode;

public class FieldAlreadyExist extends CustomException {

	public FieldAlreadyExist() {
		super(ErrorCode.FIELD_ALREADY_EXIST, HttpStatus.UNAUTHORIZED);
	}

}
