package com.fastcampus.springrunner.divelog;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest(args = {"--app.name=dive-log-test"})
class ApplicationArgumentsTest {

	@Test
	void testApplicationArguments(@Autowired ApplicationArguments arguments) {
		assertThat(arguments.getOptionNames()).containsOnly("app.name");
		assertThat(arguments.getOptionValues("app.name")).containsOnly("dive-log-test");
	}
}
