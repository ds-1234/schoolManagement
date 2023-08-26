package com.project.school.management.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.school.management.response.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exception(Exception ex) {
		log.error("Exception: ", ex);
		return buildResponseEntity(new Response(ex), HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	@ExceptionHandler(HttpClientErrorException.class)
//	public ResponseEntity<Object> restTemplateexception(HttpClientErrorException ex) {
//		log.error("Exception: ", ex);
//		Map<String, Object> map = new HashMap<>(0);
//		if (!HttpStatus.UNAUTHORIZED.equals(ex.getStatusCode())) {
//			map = new JSONObject(ex.getResponseBodyAsString(Charset.defaultCharset())).toMap();
//		}
//		return ResponseEntity.status(ex.getStatusCode()).body(map);
//	}

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
