package com.fastcampus.springrunner.divelog.web.diveresort.dto;

import javax.validation.constraints.NotBlank;

import com.fastcampus.springrunner.divelog.core.diveresort.application.dto.DiveResortUpdateCommand;
import lombok.Getter;

@Getter
public class DiveResortUpdateRequest {
	@NotBlank
	private String name;
	@NotBlank
	private String address;
	@NotBlank
	private String ownerName;
	@NotBlank
	private String contactNumber;
	@NotBlank
	private String description;

	public DiveResortUpdateCommand convertToUpdateCommand() {
		return DiveResortUpdateCommand.create(getName(), getOwnerName(), getContactNumber(), getAddress(), getDescription());
	}
}
