package com.fastcampus.springrunner.divelog.core.divelog.application;

import java.util.List;
import java.util.Optional;

import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogDto;

public interface DiveLogFinder {
	List<DiveLogDto> findAll();
	List<DiveLogDto> findByDivePointId(Long divePointId);
	Optional<DiveLogDto> findById(Long diveLogId);
}
