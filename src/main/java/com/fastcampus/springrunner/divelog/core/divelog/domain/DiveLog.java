package com.fastcampus.springrunner.divelog.core.divelog.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePoint;
import lombok.Getter;

@Getter
@Entity
public class DiveLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name = "dive_point_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private DivePoint divePoint;
	private LocalDate diveDate;
	private LocalTime entryTime;
	private LocalTime exitTime;
	private String weather;
	private String buddyName;
	private String note;
	private LocalDateTime createdDateTime;
	private LocalDateTime lastModifiedDateTime;

	public static DiveLog create(DivePoint divePoint, LocalDate diveDate, LocalTime entryTime, LocalTime exitTime, String weather, String buddyName, String note) {
		DiveLog diveLog = new DiveLog();
		diveLog.divePoint = divePoint;
		diveLog.diveDate = diveDate;
		diveLog.entryTime = entryTime;
		diveLog.exitTime = exitTime;
		diveLog.weather = weather;
		diveLog.buddyName = buddyName;
		diveLog.note = note;
		diveLog.createdDateTime = LocalDateTime.now();
		diveLog.lastModifiedDateTime = diveLog.getCreatedDateTime();

		return diveLog;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DiveLog diveLog = (DiveLog) o;
		return Objects.equals(divePoint, diveLog.divePoint) && Objects.equals(diveDate, diveLog.diveDate) && Objects.equals(entryTime, diveLog.entryTime) && Objects.equals(exitTime, diveLog.exitTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, divePoint, diveDate, entryTime, exitTime);
	}

	public void update(LocalDate diveDate, LocalTime entryTime, LocalTime exitTime, String weather, String buddyName, String note) {
		this.diveDate = diveDate;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
		this.weather = weather;
		this.buddyName = buddyName;
		this.note = note;
		this.lastModifiedDateTime = LocalDateTime.now();
	}
}
