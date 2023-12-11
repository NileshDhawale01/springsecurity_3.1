package com.nsd.datasource.exceptions;

import static com.nsd.datasource.contants.ProductConstants.*;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Map<Object, Object>> handleNullPointerException(NullPointerException ex) {

		Map<Object, Object> map = new HashMap<>();
		map.put(MESSAGE, ex.getMessage());
		map.put(CUSTOM_MESSAGE, "NullPointerException occured");
		return new ResponseEntity<>(map, HttpStatusCode.valueOf(500));
	}

	@ExceptionHandler(ExpiredJwtException.class)
	public ResponseEntity<Map<Object, Object>> expiredJwtExceptionHandler(ExpiredJwtException exp) {

		Map<Object, Object> map = new HashMap<>();
		map.put(MESSAGE, exp.getMessage());
		map.put(CUSTOM_MESSAGE, "ExpiredJwtException occured.");
		return new ResponseEntity<>(map, HttpStatusCode.valueOf(500));
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<Object, Object>> runTime(RuntimeException exp) {

		Map<Object, Object> map = new HashMap<>();
		map.put(MESSAGE, exp.getMessage());
		map.put(CUSTOM_MESSAGE, "RuntimeException occured.");
		return new ResponseEntity<>(map, HttpStatusCode.valueOf(500));
	}
}
