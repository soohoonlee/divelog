package com.fastcampus.springrunner.divelog.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan()
@EnableConfigurationProperties({MyServiceProperties.class})
public class AppConfiguration {
}
