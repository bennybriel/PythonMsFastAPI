package com.PostGraduateLog.PostGraduateLog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="u_g_student_accounts")
public class Transactions {
    @Id
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
    private LocalDateTime created_at;
}
