package com.fastcampus.springrunner.divelog.core.diveresort.domain;

import java.util.List;
import java.util.Optional;

public interface DivePointRepository {
	List<DivePoint> findAll();
	List<DivePoint> findByDiveResort(DiveResort diveResort);
	List<DivePoint> findByName(String name);
	Optional<DivePoint> findById(Long id);
	DivePoint save(DivePoint divePoint);
	void delete(DivePoint divePoint);
	void deleteAll();
}
