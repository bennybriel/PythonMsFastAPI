package com.PostGraduateLog.PostGraduateLog.repository;

import com.PostGraduateLog.PostGraduateLog.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
   List<ActivityLog> findByUserName(String userName);
}
