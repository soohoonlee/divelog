package com.fastcampus.springrunner.divelog.core.divelog.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fastcampus.springrunner.divelog.InMemoryDataJpaTest;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePoint;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePointRepository;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResortRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

@InMemoryDataJpaTest
class DiveLogRepositoryTest {
	@Autowired
	DiveResortRepository diveResortRepository;
	@Autowired
	DivePointRepository divePointRepository;
	@Autowired
	DiveLogRepository diveLogRepository;

	private DiveResort diveResort;
	private DivePoint divePoint;

	@BeforeEach
	void setUp() {
		diveResort = DiveResort.create("보정리조트", "이보정", "031-123-4567", "경기도 용인시", "보정리조트 입니다.");
		diveResortRepository.save(diveResort);

		divePoint = DivePoint.create(diveResort, "보정포인트", "10~15m", "경기도 용인시 보정수영장 입니다.");
		divePointRepository.save(divePoint);
	}

	@AfterEach
	void tearDown() {
		diveLogRepository.deleteAll();
		divePointRepository.deleteAll();
		diveResortRepository.deleteAll();
	}

	@Test
	void testSave() {
		LocalDate diveDate = LocalDate.now();
		LocalTime entryTime = LocalTime.of(10, 0, 0);
		LocalTime exitTime = LocalTime.of(10, 30, 30);
		String weather = "맑음";
		String buddyName = "김카드";
		String note = "아직 없음";
		DiveLog diveLog = DiveLog.create(divePoint, diveDate, entryTime, exitTime, weather, buddyName, note);

		diveLogRepository.save(diveLog);

		Assertions.assertThat(diveLog.getId()).isNotNull();
	}
}