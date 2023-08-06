package com.project.school.management.exception;

public class FieldAlreadyExist extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public FieldAlreadyExist(String message) {
		super(message);
	}

	public FieldAlreadyExist() {
		super();
	}

}
