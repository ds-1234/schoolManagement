package com.project.school.management.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.school.management.entity.ExceptionEntity;
import com.project.school.management.repository.ExceptionRepository;
import com.project.school.management.response.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ExceptionRepository exceptionRepository;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exception(Exception ex) {
		log.error("Exception: ", ex);
		ExceptionEntity data = new ExceptionEntity();
		data.setError(ex.getMessage());
		data.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		data.setTrac(ExceptionUtils.getStackTrace(ex));
		exceptionRepository.save(data);
		return buildResponseEntity(new Response(ex), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity<Object> illegelException(Exception ex) {
		log.error("Exception: ", ex);
		return buildResponseEntity(new Response(ex), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> customException(CustomException ex) {
		log.error("Exception: ", ex);
		return buildResponseEntity(new Response(ex), ex.getHttpStatus());
	}

	@ExceptionHandler(FieldAlreadyExist.class)
	public ResponseEntity<Object> fieldAlreadyExist(FieldAlreadyExist ex) {
		log.error("Exception: ", ex);
		Response response = new Response(ex);
		return buildResponseEntity(response, ex.getHttpStatus());
	}

	@ExceptionHandler(InvalidArgumentException.class)
	public ResponseEntity<Object> invalidArgumentException(InvalidArgumentException ex) {
		log.error("Exception: ", ex);
		Response response = new Response(ex);
		return buildResponseEntity(response, ex.getHttpStatus());
	}

	@ExceptionHandler(InvalidRoleException.class)
	public ResponseEntity<Object> invalidRoleException(InvalidRoleException ex) {
		log.error("Exception: ", ex);
		Response response = new Response(ex);
		return buildResponseEntity(response, ex.getHttpStatus());
	}

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<Object> userAlreadyExistException(UserAlreadyExistException ex) {
		log.error("Exception: ", ex);
		Response response = new Response(ex);
		return buildResponseEntity(response, ex.getHttpStatus());
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException(UserNotFoundException ex) {
		log.error("Exception: ", ex);
		Response response = new Response(ex);
		return buildResponseEntity(response, ex.getHttpStatus());
	}

	private ResponseEntity<Object> buildResponseEntity(Response response, HttpStatus status) {
		return new ResponseEntity<>(response, status);
	}

}
