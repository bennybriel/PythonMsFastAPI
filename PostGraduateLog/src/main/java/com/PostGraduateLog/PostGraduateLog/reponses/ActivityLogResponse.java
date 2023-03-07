package com.PostGraduateLog.PostGraduateLog.reponses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ActivityLogResponse {
    private  long id;
    private String userName;
    private String operation;
    private String ipAddress;
    private String macAddress;
    private String platForm;
    private String browser;
    private String guid;
    private LocalDateTime createdAt;
}
