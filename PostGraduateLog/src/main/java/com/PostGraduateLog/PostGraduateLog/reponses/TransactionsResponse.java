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
public class TransactionsResponse {
    private long id;
    private Integer productID;
    private String matricno;
    private String description;
    private String response;
    private String transactionID;
    private Double amount;
    private String apptype;
    private String session;
    private String referenceID;
    private String trans_id;
    private String url;
    private String paymenttype;
    private String guid;
    private Boolean ispaid;
    private Boolean status;
    private LocalDateTime updated_at;
    private LocalDateTime create_at;

}
