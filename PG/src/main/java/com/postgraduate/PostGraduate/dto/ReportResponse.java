package com.postgraduate.PostGraduate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ReportResponse {
    private String id;
    private String  apptype;
    private String matricno;
    private String name;
    private String description;
    private BigDecimal amount;
}
