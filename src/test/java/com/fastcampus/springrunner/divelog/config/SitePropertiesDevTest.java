package com.fastcampus.springrunner.divelog.config;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("dev")
@SpringBootTest
class SitePropertiesDevTest {

	@Test
	void test(@Autowired SiteProperties siteProperties) {
		assertThat(siteProperties.getAuthorName()).isEqualTo("soohoonlee-dev");
		assertThat(siteProperties.getAuthorEmail()).isEqualTo("soohoon.lee1982.dev@gmail.com");
	}
}