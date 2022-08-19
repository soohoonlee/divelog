package com.fastcampus.springrunner.divelog.core.divelog.application.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fastcampus.springrunner.divelog.core.divelog.domain.DiveLog;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePoint;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
public class DiveLogDto {
	private Long id;
	private Long diveResortId;
	private String diveResortName;
	private Long divePointId;
	private String divePointName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate diveDate;
	@JsonFormat(pattern = "'T'HH:mm:ss")
	private LocalTime entryTime;
	@JsonFormat(pattern = "'T'HH:mm:ss")
	private LocalTime exitTime;
	private String weather;
	private String buddyName;
	private String note;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdDateTime;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime lastModifiedDateTime;

	public static DiveLogDto ofEntity(DiveLog diveLog) {
		DiveLogDto diveLogDto = new DiveLogDto();
		diveLogDto.id = diveLog.getId();
		DiveResort diveResort = diveLog.getDivePoint().getDiveResort();
		diveLogDto.diveResortId = diveResort.getId();
		diveLogDto.diveResortName = diveResort.getName();
		DivePoint divePoint = diveLog.getDivePoint();
		diveLogDto.divePointId = divePoint.getId();
		diveLogDto.divePointName = divePoint.getName();
		diveLogDto.diveDate = diveLog.getDiveDate();
		diveLogDto.entryTime = diveLog.getEntryTime();
		diveLogDto.exitTime = diveLog.getExitTime();
		diveLogDto.weather = diveLog.getWeather();
		diveLogDto.buddyName = diveLog.getBuddyName();
		diveLogDto.note = diveLog.getNote();
		diveLogDto.createdDateTime = diveLog.getCreatedDateTime();
		diveLogDto.lastModifiedDateTime = diveLog.getLastModifiedDateTime();

		return diveLogDto;
	}
}
