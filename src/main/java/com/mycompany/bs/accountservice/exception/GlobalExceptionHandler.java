package com.mycompany.bs.accountservice.exception;

import static java.time.Instant.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(value = NOT_FOUND)
	public ErrorMessage noSuchElementException(NoSuchElementException ex, WebRequest web) {
		log.error(ex.getMessage(), ex);
		return new ErrorMessage(NOT_FOUND.value(), ex.getMessage(), now());
	}
}
