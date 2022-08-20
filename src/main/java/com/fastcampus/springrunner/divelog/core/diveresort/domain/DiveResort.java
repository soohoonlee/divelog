package com.fastcampus.springrunner.divelog.core.diveresort.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;

import com.fastcampus.springrunner.divelog.core.common.AbstractEntity;
import lombok.Getter;

import org.springframework.util.Assert;

@Getter
@Entity
public class DiveResort extends AbstractEntity {
	private String name;
	private String ownerName;
	private String contactNumber;
	private String address;
	private String description;
	private LocalDateTime createdDateTime;
	private LocalDateTime lastModifiedDateTime;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DiveResort that = (DiveResort) o;
		return Objects.equals(name, that.name) && Objects.equals(ownerName, that.ownerName) && Objects.equals(contactNumber, that.contactNumber) && Objects.equals(address, that.address) && Objects.equals(description, that.description) && Objects.equals(createdDateTime, that.createdDateTime) && Objects.equals(lastModifiedDateTime, that.lastModifiedDateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, ownerName, contactNumber, address, description, createdDateTime, lastModifiedDateTime);
	}

	public static DiveResort create(String name, String ownerName, String contactNumber, String address, String description) {
		validateDiveResortArguments(name, ownerName, contactNumber, address, description);

		DiveResort diveResort = new DiveResort();
		diveResort.name = name;
		diveResort.ownerName = ownerName;
		diveResort.contactNumber = contactNumber;
		diveResort.address = address;
		diveResort.description = description;
		diveResort.createdDateTime = LocalDateTime.now();
		diveResort.lastModifiedDateTime = diveResort.getCreatedDateTime();

		return diveResort;
	}

	public void update(String name, String ownerName, String contactNumber, String address, String description) {
		validateDiveResortArguments(name, ownerName, contactNumber, address, description);

		this.name = name;
		this.ownerName = ownerName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.description = description;
		this.lastModifiedDateTime = LocalDateTime.now();
	}

	private static void validateDiveResortArguments(String name, String ownerName, String contactNumber, String address, String description) {
		Assert.hasText(name, "name 은 필수 입력값 입니다.");
		Assert.hasText(ownerName, "ownerName 은 필수 입력값 입니다.");
		Assert.hasText(contactNumber, "contactNumber 은 필수 입력값 입니다.");
		Assert.hasText(address, "address 은 필수 입력값 입니다.");
		Assert.hasText(description, "description 은 필수 입력값 입니다.");
	}
}
