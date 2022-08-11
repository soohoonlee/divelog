package com.fastcampus.springrunner.divelog.config;

import java.net.InetAddress;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("my.service")
public class MyServiceProperties {

	private boolean enabled;
	private InetAddress remoteAddress;
	private final Security security = new Security();

	@Getter
	@Setter
	public static class Security {
		private String username;
		private String password;
	}
}
