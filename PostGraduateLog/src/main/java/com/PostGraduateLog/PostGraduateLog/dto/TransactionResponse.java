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
public class TransactionResponse {
    private Long id;
    private String guid;
    private String matricno;
    private String description;
    private String response;
    private String transactionid;
    private String apptype;
    private String session;
    private String referenceid;
    private String trans_id;
    private String url;
    private String paymenttype;
    private Integer productid;
    private Double amount;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Boolean ispaid;
    private Boolean status;
}
