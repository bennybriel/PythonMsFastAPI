package com.PostGraduateLog.PostGraduateLog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserByAppSessionRequest {
    private String apptype;
    private String activesession;
}
