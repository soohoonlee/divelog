package com.fastcampus.springrunner.divelog.core.diveresort.application;

import com.fastcampus.springrunner.divelog.core.diveresort.application.dto.DiveResortDto;
import com.fastcampus.springrunner.divelog.core.diveresort.application.dto.DiveResortRegisterCommand;
import com.fastcampus.springrunner.divelog.core.diveresort.application.dto.DiveResortUpdateCommand;

public interface DiveResortEditor {
	DiveResortDto save(DiveResortRegisterCommand registerCommand);
	DiveResortDto update(Long diveResortId, DiveResortUpdateCommand updateCommand);
	void delete(Long diveResortId);
}
