package com.fastcampus.springrunner.divelog.core.diveresort.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fastcampus.springrunner.divelog.core.common.AbstractEntity;
import lombok.Getter;

import org.springframework.util.Assert;

@Getter
@Entity
public class DivePoint extends AbstractEntity {
	@JoinColumn(name = "dive_resort_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private DiveResort diveResort;
	private String name;
	private String depth;
	private String description;

	private LocalDateTime createdDateTime;
	private LocalDateTime lastModifiedDateTime;

	public static DivePoint create(DiveResort diveResort, String name, String depth, String description) {
		validateDivePointArguments(name, depth, description);

		DivePoint divePoint = new DivePoint();
		divePoint.diveResort = diveResort;
		divePoint.name = name;
		divePoint.depth = depth;
		divePoint.description = description;
		divePoint.createdDateTime = LocalDateTime.now();
		divePoint.lastModifiedDateTime = divePoint.getCreatedDateTime();

		return divePoint;
	}

	public void update(String name, String depth, String description) {
		validateDivePointArguments(name, depth, description);

		this.name = name;
		this.depth = depth;
		this.description = description;
		this.lastModifiedDateTime = LocalDateTime.now();
	}

	private static void validateDivePointArguments(String name, String depth, String description) {
		Assert.hasText(name, "name 은 필수 입력값 입니다.");
		Assert.hasText(depth, "depth 는 필수 입력값 입니다.");
		Assert.hasText(description, "description 은 필수 입력값 입니다.");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		DivePoint divePoint = (DivePoint) o;
		return Objects.equals(diveResort, divePoint.diveResort) && Objects.equals(name, divePoint.name) && Objects.equals(depth, divePoint.depth) && Objects.equals(description, divePoint.description) && Objects.equals(createdDateTime, divePoint.createdDateTime) && Objects.equals(lastModifiedDateTime, divePoint.lastModifiedDateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), diveResort, name, depth, description, createdDateTime, lastModifiedDateTime);
	}
}
