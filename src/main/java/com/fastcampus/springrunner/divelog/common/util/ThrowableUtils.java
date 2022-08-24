package com.fastcampus.springrunner.divelog.common.util;

import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.validation.BindingResult;

public interface ThrowableUtils {
	static Throwable getRootCause(Throwable throwable) {
		if (Objects.nonNull(throwable)) {
			return Stream.iterate(throwable, Throwable::getCause)
					.filter(element -> Objects.isNull(element.getCause()))
					.findFirst()
					.orElse(throwable);
		}
		return null;
	}

	static BindingResult extractBindingResult(Throwable error) {
		if (error instanceof BindingResult bindingResult) {
			return bindingResult;
		}
		return null;
	}

}
