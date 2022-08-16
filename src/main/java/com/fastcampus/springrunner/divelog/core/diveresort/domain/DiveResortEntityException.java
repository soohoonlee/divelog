package com.fastcampus.springrunner.divelog.core.diveresort.domain;

import com.fastcampus.springrunner.divelog.common.exception.SystemException;

@SuppressWarnings("serial")
public class DiveResortEntityException extends SystemException {
	public DiveResortEntityException(String message, Object...args) {
		super(String.format(message, args));
	}
}
