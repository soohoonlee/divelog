package com.fastcampus.springrunner.divelog.core.diveresort.domain;

import com.fastcampus.springrunner.divelog.common.exception.SystemException;

@SuppressWarnings("serial")
public class DivePointEntityException extends SystemException {
	public DivePointEntityException(String message, Object...args) {
		super(String.format(message, args));
	}
}
