package com.fastcampus.springrunner.divelog.web.diveresort;

import com.fastcampus.springrunner.divelog.IntegrationMockMvcRestDocsTest;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResort;
import com.fastcampus.springrunner.divelog.core.diveresort.domain.DiveResortRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IntegrationMockMvcRestDocsTest
class DiveResortRestControllerRestDocsTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private DiveResortRepository diveResortRepository;

	private DiveResort diveResort;

	@BeforeEach
	void setUp() {
		diveResort = DiveResort.create("보정리조트", "이보정", "031-123-4567", "경기도 용인시", "보정리조트 입니다.");
		diveResortRepository.save(diveResort);
	}

	@AfterEach
	void tearDown() {
		diveResortRepository.deleteAll();
	}

	@Test
	void testGetDiveResorts() throws Exception {
		this.mockMvc.perform(get("/dive-resorts")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andDo(document("dive-resorts-get-list",
						Preprocessors.preprocessRequest(Preprocessors.prettyPrint()),
						Preprocessors.preprocessResponse(Preprocessors.prettyPrint()),
						responseFields(fieldWithPath("[].id").description("리조트 번호"),
								fieldWithPath("[].name").description("리조트 이름"),
								fieldWithPath("[].address").description("리조트 주소"),
								fieldWithPath("[].ownerName").description("리조트 소유주"),
								fieldWithPath("[].contactNumber").description("리조트 연락처"),
								fieldWithPath("[].description").description("리조트 설명"),
								fieldWithPath("[].createdDateTime").description("생성일시"),
								fieldWithPath("[].lastModifiedDateTime").description("최근변경일시"))));
	}
}
