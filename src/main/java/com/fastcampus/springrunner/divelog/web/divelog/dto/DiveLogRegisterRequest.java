package com.fastcampus.springrunner.divelog.web.divelog.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogRegisterCommand;
import lombok.Builder;
import lombok.Getter;

import org.springframework.format.annotation.DateTimeFormat;

@Getter
public class DiveLogRegisterRequest {
	@NotNull
	private Long divePointId;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate diveDate;
	@NotNull
	@DateTimeFormat(pattern = "hh:mm:ss")
	private LocalTime entryTime;
	@NotNull
	@DateTimeFormat(pattern = "hh:mm:ss")
	private LocalTime exitTime;
	@NotEmpty
	private String weather;
	@NotEmpty
	private String buddyName;
	@NotEmpty
	private String note;

	@Builder
	public DiveLogRegisterRequest(Long divePointId, LocalDate diveDate, LocalTime entryTime, LocalTime exitTime, String weather, String buddyName, String note) {
		this.divePointId = divePointId;
		this.diveDate = diveDate;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
		this.weather = weather;
		this.buddyName = buddyName;
		this.note = note;
	}

	public DiveLogRegisterCommand convertToRegisterCommand() {
		return DiveLogRegisterCommand.create(getDivePointId(), getDiveDate(), getEntryTime(), getExitTime(), getWeather(), getBuddyName(), getNote());
	}
}
