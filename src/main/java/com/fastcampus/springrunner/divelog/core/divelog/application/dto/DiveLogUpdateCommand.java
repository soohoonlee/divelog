package com.fastcampus.springrunner.divelog.core.divelog.application.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fastcampus.springrunner.divelog.core.divelog.domain.DiveLog;
import lombok.Getter;

@Getter
public class DiveLogUpdateCommand {
	private LocalDate diveDate;
	private LocalTime entryTime;
	private LocalTime exitTime;
	private String weather;
	private String buddyName;
	private String note;

	public static DiveLogUpdateCommand create(
			@NotNull LocalDate diveDate,
			@NotNull LocalTime entryTime,
			@NotNull LocalTime exitTime,
			@NotEmpty String weather,
			@NotEmpty String buddyName,
			@NotEmpty String note) {
		DiveLogUpdateCommand updateCommand = new DiveLogUpdateCommand();
		updateCommand.diveDate = diveDate;
		updateCommand.entryTime = entryTime;
		updateCommand.exitTime = exitTime;
		updateCommand.weather = weather;
		updateCommand.buddyName = buddyName;
		updateCommand.note = note;

		return updateCommand;
	}

	public DiveLog update(DiveLog diveLog) {
		diveLog.update(diveDate, entryTime, exitTime, weather, buddyName, note);
		return diveLog;
	}
}
