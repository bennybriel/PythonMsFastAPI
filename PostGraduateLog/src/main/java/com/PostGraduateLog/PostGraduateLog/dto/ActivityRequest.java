package com.PostGraduateLog.PostGraduateLog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {
    private  long id;
    private String userName;
    private String operation;
    private String ipAddress;
    private String macAddress;
    private String platForm;
    private String browser;
    private String guid;
}
