package com.fastcampus.springrunner.divelog.core.diveresort.application.dto;

import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;
import lombok.Getter;

@Getter
public class DiveResortRegisterCommand {
	private String name;
	private String ownerName;
	private String contactNumber;
	private String address;
	private String description;

	public static DiveResortRegisterCommand create(String name, String ownerName, String contactNumber, String address, String description) {
		DiveResortRegisterCommand diveResortRegisterCommand = new DiveResortRegisterCommand();
		diveResortRegisterCommand.name = name;
		diveResortRegisterCommand.ownerName = ownerName;
		diveResortRegisterCommand.contactNumber = contactNumber;
		diveResortRegisterCommand.address = address;
		diveResortRegisterCommand.description = description;
		return diveResortRegisterCommand;
	}

	public DiveResort convertToEntity() {
		return DiveResort.create(getName(), getName(), getContactNumber(), getAddress(), getDescription());
	}
}
