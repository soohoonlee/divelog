package com.fastcampus.springrunner.divelog.core.divelog.application;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogDto;
import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogRegisterCommand;
import com.fastcampus.springrunner.divelog.core.divelog.domain.DiveLogRepository;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePoint;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePointRepository;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResortRepository;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DiveLogManagerTest {
	@Autowired
	DiveResortRepository diveResortRepository;
	@Autowired
	DivePointRepository divePointRepository;
	@Autowired
	DiveLogRepository diveLogRepository;
	@Autowired
	DiveLogManager diveLogManager;

	DiveResort diveResort;
	DivePoint divePoint;

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

		DiveLogRegisterCommand registerCommand = DiveLogRegisterCommand.create(divePoint.getId(), diveDate, entryTime, exitTime, weather, buddyName, note);
		DiveLogDto diveLogDto = diveLogManager.save(registerCommand);

		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(diveLogDto.getId()).isNotNull();
			softAssertions.assertThat(diveLogDto.getDiveResortId()).isEqualTo(diveResort.getId());
			softAssertions.assertThat(diveLogDto.getDiveResortName()).isEqualTo(diveResort.getName());
			softAssertions.assertThat(diveLogDto.getDivePointId()).isEqualTo(divePoint.getId());
			softAssertions.assertThat(diveLogDto.getDivePointName()).isEqualTo(divePoint.getName());
			softAssertions.assertThat(diveLogDto.getDiveDate()).isEqualTo(diveDate);
			softAssertions.assertThat(diveLogDto.getEntryTime()).isEqualTo(entryTime);
			softAssertions.assertThat(diveLogDto.getExitTime()).isEqualTo(exitTime);
			softAssertions.assertThat(diveLogDto.getWeather()).isEqualTo(weather);
			softAssertions.assertThat(diveLogDto.getBuddyName()).isEqualTo(buddyName);
			softAssertions.assertThat(diveLogDto.getNote()).isEqualTo(note);
			softAssertions.assertThat(diveLogDto.getCreatedDateTime()).isNotNull();
			softAssertions.assertThat(diveLogDto.getLastModifiedDateTime()).isNotNull();
			softAssertions.assertThat(diveLogDto.getLastModifiedDateTime()).isEqualTo(diveLogDto.getCreatedDateTime());
		});
	}
}