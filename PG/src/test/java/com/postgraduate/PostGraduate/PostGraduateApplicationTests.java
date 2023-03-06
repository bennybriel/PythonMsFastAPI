package com.postgraduate.PostGraduate;

import com.mongodb.assertions.Assertions;
import com.postgraduate.PostGraduate.dto.ReportRequest;
import com.postgraduate.PostGraduate.repository.ReportRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc

class PostGraduateApplicationTests {
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	private ReportRepository reportRepository;
	@DynamicPropertySource

	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry){
		dymDynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateReport() throws Exception {
	  ReportRequest reportRequest =	getReportRequest();
		String reportRequestString = objectMapper.writeValueAsString(reportRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/report")
				.contentType(MediaType.APPLICATION_JSON)
				.content(reportRequestString))
				.andExpect(status().isCreated());
		;
		Assertions.assertTrue(reportRepository.findAll().size()== 1);
	}

	private ReportRequest getReportRequest()
	{
		return ReportRequest.builder()
				.amount(BigDecimal.valueOf(10000))
				.name("Adeola")
				.description("Test Application")
				.matricno("12345")
				.apptype("PG")
				.build();
	}

}
