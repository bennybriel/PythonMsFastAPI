package com.PostGraduateLog.PostGraduateLog;

import com.PostGraduateLog.PostGraduateLog.model.ActivityLog;
import com.PostGraduateLog.PostGraduateLog.repository.ActivityLogRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.ObjectRowListProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostGraduateLogApplicationTests {

	@Autowired
	ActivityLogRepository activityLogRepository;

	@Test
	@Order(1)
	public void    createActivityloger()
	{
		ActivityLog activityLog = new ActivityLog();
		activityLog.setMacAddress("47444.477474gdgeyy");
		activityLog.setOperation("Login");
		activityLog.setUserName("Admin");
		activityLog.setPlatForm("Portal");
		activityLog.setIpAddress("1.1.1.1");
		activityLog.setGuid(UUID.randomUUID().toString());
		activityLog.setBrowser("Mozilla");
		activityLog.setCreatedAt(LocalDateTime.now());
		activityLogRepository.save(activityLog);
		assertNotNull(activityLogRepository.findById(1L).get());
	}

	@Test
	@Order(2)
	public void testReadAll()
	{
		List<ActivityLog> act = activityLogRepository.findAll();
		assertThat(act).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testSingleActivityLog()
	{
	  ActivityLog activityLog=	activityLogRepository.findById(1L).get();
	  assertEquals("Chrome",activityLog.getBrowser());
	}

	@Test
	@Order(4)
	public void testUpdate()
	{
	 ActivityLog activityLog=activityLogRepository.findById(1L).get();
	 activityLog.setBrowser("Edge");
	 activityLogRepository.save(activityLog);
	 assertNotEquals("Browser", activityLogRepository.findById(1L).get().getBrowser());
	}

	@Test
	@Order(5)
	public void testDelete()
	{
		activityLogRepository.deleteById(1L);
		assertThat(activityLogRepository.existsById(1L)).isFalse();
	}



}
