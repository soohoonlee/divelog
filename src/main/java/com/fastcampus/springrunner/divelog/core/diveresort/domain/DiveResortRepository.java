package com.fastcampus.springrunner.divelog.core.diveresort.domain;

import java.util.List;
import java.util.Optional;

public interface DiveResortRepository {
	List<DiveResort> findAll();
	List<DiveResort> findByName(String name);
	List<DiveResort> findByOwnerName(String ownerName);
	Optional<DiveResort> findByContactNumber(String contactNumber);
	Optional<DiveResort> findById(Long id);
	DiveResort save(DiveResort diveResort);
	void delete(DiveResort diveResort);
	void deleteAll();
}
