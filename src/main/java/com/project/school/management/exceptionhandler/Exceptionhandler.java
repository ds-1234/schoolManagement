package com.project.school.management.exceptionhandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.school.management.exception.DataNotExist;
import com.project.school.management.exception.FieldAlreadyExist;
import com.project.school.management.exception.InvalidRequestException;
import com.project.school.management.exception.InvalidRoleException;
import com.project.school.management.exception.UserAlreadyExistException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RestControllerAdvice
public class Exceptionhandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException ex) {
		String errorCode = String.valueOf(new Date().getTime());
		log.error(" ====>>>> " + errorCode + "===>>> " + ex.getMessage() );
		Map<String, String> errors = new HashMap<>();
		errors.put("message", ex.getMessage());
		errors.put("status", "");
		errors.put("data", "");
		errors.put("errorCode", errorCode);
//		errors.put("error", ex.getCause().getMessage());
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidRoleException.class)
	public ResponseEntity<Object> handleInvalidRoleException(InvalidRoleException ex) {
		String errorCode = String.valueOf(new Date().getTime());
		log.error(" ====>>>> " + errorCode + "===>>> " + ex.getMessage() );
		Map<String, String> errors = new HashMap<>();
		errors.put("message", ex.getMessage());
		errors.put("status", "");
		errors.put("data", "");
		errors.put("errorCode", errorCode);
//		errors.put("error", ex.getCause().getMessage());
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(FieldAlreadyExist.class)
	public ResponseEntity<Object> handleFieldAlreadyExistException(FieldAlreadyExist ex) {
		String errorCode = String.valueOf(new Date().getTime());
		log.error(" ====>>>> " + errorCode + "===>>> " + ex.getMessage() );
		Map<String, String> errors = new HashMap<>();
		errors.put("message", ex.getMessage());
		errors.put("status", "");
		errors.put("data", "");
		errors.put("errorCode", errorCode);
//		errors.put("error", ex.getCause().getMessage());
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(DataNotExist.class)
	public ResponseEntity<Object> handleDataNotExistException(DataNotExist ex) {
		String errorCode = String.valueOf(new Date().getTime());
		log.error(" ====>>>> " + errorCode + "===>>> " + ex.getMessage() );
		Map<String, String> errors = new HashMap<>();
		errors.put("message", ex.getMessage());
		errors.put("status", "");
		errors.put("data", "");
		errors.put("errorCode", errorCode);
//		errors.put("error", ex.getCause().getMessage());
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<Object> handleInvalidRequestException(InvalidRequestException ex) {
		String errorCode = String.valueOf(new Date().getTime());
		log.error(" ====>>>> " + errorCode + "===>>> " + ex.getMessage() );
		Map<String, String> errors = new HashMap<>();
		errors.put("message", ex.getMessage());
		errors.put("status", "");
		errors.put("data", "");
		errors.put("errorCode", errorCode);
//		errors.put("error", ex.getCause().getMessage());
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

	}

}
