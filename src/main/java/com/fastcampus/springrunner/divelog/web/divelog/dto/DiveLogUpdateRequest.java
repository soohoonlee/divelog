package com.fastcampus.springrunner.divelog.web.divelog.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogUpdateCommand;
import lombok.Getter;

import org.springframework.format.annotation.DateTimeFormat;

@Getter
public class DiveLogUpdateRequest {
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

	public DiveLogUpdateCommand convertToUpdateCommand() {
		return DiveLogUpdateCommand.create(getDiveDate(), getEntryTime(), getExitTime(), getWeather(), getBuddyName(), getNote());
	}
}
