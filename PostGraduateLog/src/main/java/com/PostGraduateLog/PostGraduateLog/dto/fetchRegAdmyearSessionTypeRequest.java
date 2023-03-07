package com.PostGraduateLog.PostGraduateLog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class fetchRegAdmyearSessionTypeRequest {
    private String admissionyear;
    private String admissiontype;
    private String session;
}
