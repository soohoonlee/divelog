package com.fastcampus.springrunner.divelog.core.divelog.application;

import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogDto;
import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogRegisterCommand;
import com.fastcampus.springrunner.divelog.core.divelog.application.dto.DiveLogUpdateCommand;

public interface DiveLogEditor {
	DiveLogDto save(DiveLogRegisterCommand registerCommand);
	DiveLogDto update(Long diveLogId, DiveLogUpdateCommand updateCommand);
	void delete(Long diveLogId);
}
