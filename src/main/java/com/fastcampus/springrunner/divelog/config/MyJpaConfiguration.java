package com.fastcampus.springrunner.divelog.config;

import com.fastcampus.springrunner.divelog.core.divelog.domain.DiveLog;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

// @EntityScan({
// 		"com.fastcampus.springrunner.divelog.core.diveresort.domain",
// 		"com.fastcampus.springrunner.divelog.core.divelog.domain"
// })
@EntityScan(basePackageClasses = {DiveResort.class, DiveLog.class})
@Configuration
public class MyJpaConfiguration {
}
