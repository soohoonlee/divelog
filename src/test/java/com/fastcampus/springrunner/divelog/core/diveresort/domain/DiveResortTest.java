package com.fastcampus.springrunner.divelog.core.diveresort.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class DiveResortTest {

	@Test
	void testCreate() {
		DiveResort diveResort = DiveResort.create("보정리조트", "이쑨", "010-1234-5678", "경기도 용인시 기흥구", "보정리조트 입니다.");

		SoftAssertions.assertSoftly(softly -> {
			softly.assertThat(diveResort.getName()).isEqualTo("보정리조트");
			softly.assertThat(diveResort.getOwnerName()).isEqualTo("이쑨");
			softly.assertThat(diveResort.getContactNumber()).isEqualTo("010-1234-5678");
			softly.assertThat(diveResort.getAddress()).isEqualTo("경기도 용인시 기흥구");
			softly.assertThat(diveResort.getDescription()).isEqualTo("보정리조트 입니다.");
			softly.assertThat(diveResort.getCreatedDateTime()).isNotNull();
			softly.assertThat(diveResort.getLastModifiedDateTime()).isNotNull();
			softly.assertThat(diveResort.getLastModifiedDateTime()).isEqualTo(diveResort.getCreatedDateTime());
		});
	}
}