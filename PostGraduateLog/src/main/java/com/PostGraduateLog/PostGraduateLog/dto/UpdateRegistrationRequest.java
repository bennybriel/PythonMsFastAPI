package com.PostGraduateLog.PostGraduateLog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRegistrationRequest {
    private String email;
    private String matric;
    private String phone;
    private LocalDateTime dob;
    private String category;
}

