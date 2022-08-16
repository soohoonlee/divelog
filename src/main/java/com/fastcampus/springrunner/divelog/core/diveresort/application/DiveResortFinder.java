package com.fastcampus.springrunner.divelog.core.diveresort.application;

import java.util.List;
import java.util.Optional;

import com.fastcampus.springrunner.divelog.core.diveresort.application.dto.DiveResortDto;

public interface DiveResortFinder {
	List<DiveResortDto> findAll();
	Optional<DiveResortDto> findByDiveResortId(Long diveResortId);
}
