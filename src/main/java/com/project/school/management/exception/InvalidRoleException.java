package com.project.school.management.exception;

public class InvalidRoleException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InvalidRoleException(String message) {
		super(message);
	}

	public InvalidRoleException() {
		super();
	}

}
