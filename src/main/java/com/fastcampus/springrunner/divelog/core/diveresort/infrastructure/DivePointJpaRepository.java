package com.fastcampus.springrunner.divelog.core.diveresort.infrastructure;

import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePoint;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePointRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DivePointJpaRepository extends DivePointRepository, JpaRepository<DivePoint, Long> {
}
