package com.fastcampus.springrunner.divelog.core.diveresort.infrastructure;

import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResortRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiveResortJpaRepository extends DiveResortRepository, JpaRepository<DiveResort, Long> {
}
