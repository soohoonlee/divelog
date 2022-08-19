package com.fastcampus.springrunner.divelog.web.error;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePointNotFoundException;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResortNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(DivePointNotFoundException.class)
	public ResponseEntity<?> handlerDivePointNotFoundException(DivePointNotFoundException notFoundException, WebRequest webRequest) {
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("timeStamp", LocalDateTime.now());
		errorMap.put("message", notFoundException.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
	}

	@ExceptionHandler(DiveResortNotFoundException.class)
	public ResponseEntity<?> handlerDiveResortNotFoundException(DiveResortNotFoundException notFoundException, WebRequest webRequest) {
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("timeStamp", LocalDateTime.now());
		errorMap.put("message", notFoundException.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
	}
}
