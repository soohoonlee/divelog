package com.fastcampus.springrunner.divelog.core.diveresort.application.dto;

import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;
import lombok.Getter;

@Getter
public class DiveResortUpdateCommand {
	private String name;
	private String ownerName;
	private String contactNumber;
	private String address;
	private String description;

	public static DiveResortUpdateCommand create(String name, String ownerName, String contactNumber, String address, String description) {
		DiveResortUpdateCommand diveResortUpdateCommand = new DiveResortUpdateCommand();
		diveResortUpdateCommand.name = name;
		diveResortUpdateCommand.ownerName = ownerName;
		diveResortUpdateCommand.contactNumber = contactNumber;
		diveResortUpdateCommand.address = address;
		diveResortUpdateCommand.description = description;
		return diveResortUpdateCommand;
	}

	public DiveResort update(DiveResort diveResort) {
		diveResort.update(getName(), getOwnerName(), getContactNumber(), getAddress(), getDescription());
		return diveResort;
	}
}
