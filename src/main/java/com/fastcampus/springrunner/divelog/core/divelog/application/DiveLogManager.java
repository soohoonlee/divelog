package com.fastcampus.springrunner.divelog.core.divelog.application;

import java.util.List;
import java.util.Optional;

import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogDto;
import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogRegisterCommand;
import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogUpdateCommand;
import com.fastcampus.springrunner.divelog.core.divelog.domain.DiveLog;
import com.fastcampus.springrunner.divelog.core.divelog.domain.DiveLogNotFoundException;
import com.fastcampus.springrunner.divelog.core.divelog.domain.DiveLogRepository;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePoint;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePointNotFoundException;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePointRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiveLogManager implements DiveLogFinder, DiveLogEditor {
	private final DiveLogRepository diveLogRepository;
	private final DivePointRepository divePointRepository;

	public DiveLogManager(DiveLogRepository diveLogRepository, DivePointRepository divePointRepository) {
		this.diveLogRepository = diveLogRepository;
		this.divePointRepository = divePointRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DiveLogDto> findAll() {
		return diveLogRepository.findAll().stream()
				.map(DiveLogDto::ofEntity)
				.toList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<DiveLogDto> findByDivePointId(Long divePointId) {
		DivePoint divePoint = divePointRepository.findById(divePointId)
				.orElseThrow(() -> new DivePointNotFoundException(divePointId));

		return diveLogRepository.findByDivePoint(divePoint).stream()
				.map(DiveLogDto::ofEntity)
				.toList();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DiveLogDto> findById(Long diveLogId) {
		return diveLogRepository.findById(diveLogId)
				.map(DiveLogDto::ofEntity);
	}

	@Override
	@Transactional
	public DiveLogDto save(DiveLogRegisterCommand registerCommand) {
		DivePoint divePoint = divePointRepository.findById(registerCommand.getDivePointId())
				.orElseThrow(() -> new DivePointNotFoundException(registerCommand.getDivePointId()));
		DiveLog savedDiveLog = diveLogRepository.save(registerCommand.convertToEntity(divePoint));

		return DiveLogDto.ofEntity(savedDiveLog);
	}

	@Override
	@Transactional
	public DiveLogDto update(Long diveLogId, DiveLogUpdateCommand updateCommand) {
		DiveLog diveLog = diveLogRepository.findById(diveLogId)
				.orElseThrow(() -> new DiveLogNotFoundException(diveLogId));
		DiveLog updatedDiveLog = diveLogRepository.save(updateCommand.update(diveLog));

		return DiveLogDto.ofEntity(updatedDiveLog);
	}

	@Override
	@Transactional
	public void delete(Long diveLogId) {
		DiveLog diveLog = diveLogRepository.findById(diveLogId)
				.orElseThrow(() -> new DiveLogNotFoundException(diveLogId));

		diveLogRepository.delete(diveLog);
	}
}
