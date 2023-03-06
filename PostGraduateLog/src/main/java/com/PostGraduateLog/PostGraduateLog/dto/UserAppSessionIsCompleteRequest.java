package com.PostGraduateLog.PostGraduateLog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAppSessionIsCompleteRequest {
    private String apptype;
    private String activesession;
    private boolean iscomplete;
}
