package br.com.kdev.listatelefonica.exception;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	private static final Logger logger = LogManager.getLogger(ExceptionHandlerAdvice.class);

	@ExceptionHandler(value = { NoSuchElementException.class, IllegalStateException.class,
			EmptyResultDataAccessException.class })
	public ResponseEntity<?> handlerMethodArgumentNotValid(NoSuchElementException exception) {
		logger.error("Exception {}, Message: {}", exception.getClass().getName(), exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

}
