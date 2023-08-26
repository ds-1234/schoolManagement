package com.project.school.management.enums;

public enum ErrorCode {

	USER_ALREADY_EXIST,

	ROLE_DOES_NOT_EXIST,

	FIELD_ALREADY_EXIST,

	INVALID_ARGUMENT,

	USER_NOT_FOUND,

	ACCED_DENIED,

	UNKNOWN;

	private final String prefix = "UserManagement.";

	public String code() {
		StringBuilder code = new StringBuilder();
		code.append(prefix).append(this);
		return code.toString();
	}

}
