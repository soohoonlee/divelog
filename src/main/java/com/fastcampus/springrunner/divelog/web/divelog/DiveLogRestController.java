package com.fastcampus.springrunner.divelog.web.divelog;

import java.util.List;
import java.util.stream.Collectors;

import com.fastcampus.springrunner.divelog.core.divelog.application.DiveLogEditor;
import com.fastcampus.springrunner.divelog.core.divelog.application.DiveLogFinder;
import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogDto;
import com.fastcampus.springrunner.divelog.web.divelog.dto.DiveLogRegisterRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dive-logs")
public class DiveLogRestController {
	private final DiveLogFinder diveLogFinder;
	private final DiveLogEditor diveLogEditor;

	public DiveLogRestController(DiveLogFinder diveLogFinder, DiveLogEditor diveLogEditor) {
		this.diveLogFinder = diveLogFinder;
		this.diveLogEditor = diveLogEditor;
	}

	@GetMapping
	public ResponseEntity<List<DiveLogDto>> findAll() {
		return ResponseEntity.ok(diveLogFinder.findAll());
	}

	@PostMapping
	public ResponseEntity<?> register(@RequestBody @Validated DiveLogRegisterRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(diveLogEditor.save(request.convertToRegisterCommand()));
	}
	// TODO GET /dive-logs/{diveLogId}
	// TODO PUT /dive-logs/{diveLogId}
	// TODO DELETE /dive-logs/{diveLogId}
}
