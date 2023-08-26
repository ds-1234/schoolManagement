package com.project.school.management.exception;

public class DataNotExist extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DataNotExist(String message) {
		super(message);
	}

	public DataNotExist() {
		super();
	}

}
