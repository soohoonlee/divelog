package com.fastcampus.springrunner.divelog.core.diveresort.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fastcampus.springrunner.divelog.core.diveresort.application.dto.DiveResortDto;
import com.fastcampus.springrunner.divelog.core.diveresort.application.dto.DiveResortRegisterCommand;
import com.fastcampus.springrunner.divelog.core.diveresort.application.dto.DiveResortUpdateCommand;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResortNotFoundException;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResortRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiveResortManager implements DiveResortFinder, DiveResortEditor {
	private final DiveResortRepository diveResortRepository;

	public DiveResortManager(DiveResortRepository diveResortRepository) {
		this.diveResortRepository = diveResortRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<DiveResortDto> findAll() {
		return diveResortRepository.findAll().stream()
				.map(DiveResortDto::ofEntity)
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<DiveResortDto> findByDiveResortId(Long diveResortId) {
		return diveResortRepository.findById(diveResortId)
				.map(DiveResortDto::ofEntity);
	}

	@Transactional
	@Override
	public DiveResortDto save(DiveResortRegisterCommand registerCommand) {
		return DiveResortDto.ofEntity(diveResortRepository.save(registerCommand.convertToEntity()));
	}

	@Transactional
	@Override
	public DiveResortDto update(Long diveResortId, DiveResortUpdateCommand updateCommand) {
		DiveResort diveResort = diveResortRepository.findById(diveResortId)
				.orElseThrow(() -> new DiveResortNotFoundException(diveResortId));
		DiveResort updatedDiveResort = diveResortRepository.save(updateCommand.update(diveResort));
		return DiveResortDto.ofEntity(updatedDiveResort);
	}

	@Transactional
	@Override
	public void delete(Long diveResortId) {
		DiveResort diveResort = diveResortRepository.findById(diveResortId)
				.orElseThrow(() -> new DiveResortNotFoundException(diveResortId));
		diveResortRepository.delete(diveResort);
	}
}
