package com.fastcampus.springrunner.divelog.core.divelog.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePoint;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;

public interface DiveLogRepository {
	List<DiveLog> findAll();
	List<DiveLog> findByDiveResort(DiveResort diveResort);
	List<DiveLog> findByDivePoint(DivePoint divePoint);
	List<DiveLog> findByDiveDate(LocalDate diveDate);
	Optional<DiveLog> findById(Long id);
	DiveLog save(DiveLog diveLog);
	void delete(DiveLog diveLog);
	void deleteAll();
}
