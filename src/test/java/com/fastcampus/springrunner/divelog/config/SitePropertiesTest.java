package com.fastcampus.springrunner.divelog.config;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SitePropertiesTest {

	@Test
	void test(@Autowired SiteProperties siteProperties) {
		assertThat(siteProperties.getAuthorName()).isEqualTo("soohoonlee-local");
		assertThat(siteProperties.getAuthorEmail()).isEqualTo("soohoon.lee1982.local@gmail.com");
	}
}