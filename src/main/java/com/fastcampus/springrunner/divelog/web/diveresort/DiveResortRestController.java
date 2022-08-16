package com.fastcampus.springrunner.divelog.web.diveresort;

import java.util.List;
import java.util.stream.Collectors;

import com.fastcampus.springrunner.divelog.core.diveresort.application.DiveResortEditor;
import com.fastcampus.springrunner.divelog.core.diveresort.application.DiveResortFinder;
import com.fastcampus.springrunner.divelog.core.diveresort.application.dto.DiveResortDto;
import com.fastcampus.springrunner.divelog.web.diveresort.dto.DiveResortRegisterRequest;
import com.fastcampus.springrunner.divelog.web.diveresort.dto.DiveResortUpdateRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dive-resorts")
public class DiveResortRestController {
	private final DiveResortFinder diveResortFinder;
	private final DiveResortEditor diveResortEditor;

	public DiveResortRestController(DiveResortFinder diveResortFinder, DiveResortEditor diveResortEditor) {
		this.diveResortFinder = diveResortFinder;
		this.diveResortEditor = diveResortEditor;
	}

	@GetMapping
	public ResponseEntity<List<DiveResortDto>> findAll() {
		return ResponseEntity.ok(diveResortFinder.findAll());
	}

	@PostMapping
	public ResponseEntity<?> register(@RequestBody @Validated DiveResortRegisterRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(diveResortEditor.save(request.convertToRegisterCommand()));
	}

	@GetMapping("/{diveResortId}")
	public ResponseEntity<DiveResortDto> findById(@PathVariable("diveResortId") Long diveResortId) {
		return ResponseEntity.of(diveResortFinder.findByDiveResortId(diveResortId));
	}

	@PutMapping("/{diveResortId}")
	public ResponseEntity<?> update(@PathVariable("diveResortId") Long diveResortId, @RequestBody @Validated DiveResortUpdateRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
		}
		return ResponseEntity.ok(diveResortEditor.update(diveResortId, request.convertToUpdateCommand()));
	}

	@DeleteMapping("/{diveResortId}")
	public ResponseEntity<Void> delete(@PathVariable("diveResortId") Long diveResortId) {
		diveResortEditor.delete(diveResortId);
		return ResponseEntity.noContent().build();
	}
}
