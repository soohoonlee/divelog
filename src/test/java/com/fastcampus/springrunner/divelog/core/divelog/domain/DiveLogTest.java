package com.fastcampus.springrunner.divelog.core.divelog.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePoint;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class DiveLogTest {
	@Test
	void testCreate() {
		DiveResort diveResort = DiveResort.create("서울숲", "서울숲 주인", "010-1234-5678", "서울시 용산구 서울숲로", "서울숲은 서울시 용산구 서울숲로 에서 자리잡은 숲입니다.");
		DivePoint divePoint = DivePoint.create(diveResort, "Point1", "10~13m", "모래바닥에 3각어초를 쌓은 지형");

		LocalDate diveDate = LocalDate.now();
		LocalTime entryTime = LocalTime.now().minusMinutes(30);
		LocalTime exitTime = LocalTime.now();
		String weather = "맑음";
		String buddyName = "김카드";
		String note = "아직 없음";
		DiveLog diveLog = DiveLog.create(divePoint, diveDate, entryTime, exitTime, weather, buddyName, note);

		SoftAssertions.assertSoftly(softly -> {
			softly.assertThat(diveLog.getDivePoint()).isEqualTo(divePoint);
			softly.assertThat(diveLog.getDiveDate()).isEqualTo(diveDate);
			softly.assertThat(diveLog.getEntryTime()).isEqualTo(entryTime);
			softly.assertThat(diveLog.getExitTime()).isEqualTo(exitTime);
			softly.assertThat(diveLog.getWeather()).isEqualTo(weather);
			softly.assertThat(diveLog.getBuddyName()).isEqualTo(buddyName);
			softly.assertThat(diveLog.getNote()).isEqualTo(note);
			softly.assertThat(diveLog.getCreatedDateTime()).isNotNull();
			softly.assertThat(diveLog.getLastModifiedDateTime()).isNotNull();
			softly.assertThat(diveLog.getLastModifiedDateTime()).isEqualTo(diveLog.getCreatedDateTime());
		});
	}
}