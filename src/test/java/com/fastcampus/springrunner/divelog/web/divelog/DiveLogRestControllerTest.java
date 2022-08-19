package com.fastcampus.springrunner.divelog.web.divelog;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fastcampus.springrunner.divelog.IntegrationMockMvcTest;
import com.fastcampus.springrunner.divelog.core.divelog.domain.DiveLogRepository;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePoint;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DivePointRepository;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResortRepository;
import com.fastcampus.springrunner.divelog.web.divelog.dto.DiveLogRegisterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@IntegrationMockMvcTest
class DiveLogRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private DiveResortRepository diveResortRepository;
	@Autowired
	private DivePointRepository divePointRepository;
	@Autowired
	private DiveLogRepository diveLogRepository;

	private DiveResort diveResort;
	private DivePoint divePoint;

	@BeforeEach
	void setUp() {
		diveResort = DiveResort.create("보정리조트", "이보정", "031-123-4567", "경기도 용인시", "보정리조트 입니다.");
		diveResortRepository.save(diveResort);

		divePoint = DivePoint.create(diveResort, "보정포인트", "10~15m", "경기도 용인시 보정수영장 입니다.");
		divePointRepository.save(divePoint);
	}

	@AfterEach
	void tearDown() {
		diveLogRepository.deleteAll();
		divePointRepository.deleteAll();
		diveResortRepository.deleteAll();
	}

	@Test
	void testFindAll() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/dive-logs")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testRegister() throws Exception {
		LocalDate diveDate = LocalDate.now();
		LocalTime entryTime = LocalTime.of(10, 0, 0);
		LocalTime exitTime = LocalTime.of(10, 30, 30);
		String weather = "맑음";
		String buddyName = "김카드";
		String note = "아직 없음";
		DiveLogRegisterRequest registerRequest = DiveLogRegisterRequest.builder()
				.divePointId(divePoint.getId())
				.diveDate(diveDate)
				.entryTime(entryTime)
				.exitTime(exitTime)
				.weather(weather)
				.buddyName(buddyName)
				.note(note)
				.build();

		this.mockMvc.perform(MockMvcRequestBuilders.post("/dive-logs")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(registerRequest)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}