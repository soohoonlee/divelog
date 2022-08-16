package com.fastcampus.springrunner.divelog.web.diveresort.dto;

import javax.validation.constraints.NotBlank;

import com.fastcampus.springrunner.divelog.core.diveresort.application.dto.DiveResortRegisterCommand;
import lombok.Getter;

@Getter
public class DiveResortRegisterRequest {
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

	public DiveResortRegisterCommand convertToRegisterCommand() {
		return DiveResortRegisterCommand.create(getName(), getOwnerName(), getContactNumber(), getAddress(), getDescription());
	}
}
