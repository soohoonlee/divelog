package com.fastcampus.springrunner.divelog.common.exception;

import org.springframework.context.MessageSourceResolvable;

@SuppressWarnings("serial")
public class SystemException extends RuntimeException implements MessageSourceResolvable {

	public SystemException(String message, Object... args) {
		super(String.format(message, args));
	}

	public SystemException(Throwable cause) {
		super(cause);
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String[] getCodes() {
		return new String[]{"Exception." + getClass().getSimpleName()};
	}

	@Override
	public Object[] getArguments() {
		return new Object[0];
	}

	@Override
	public String getDefaultMessage() {
		return getMessage();
	}
}
