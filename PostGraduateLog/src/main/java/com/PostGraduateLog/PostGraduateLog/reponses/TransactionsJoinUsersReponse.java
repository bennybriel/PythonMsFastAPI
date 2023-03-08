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
public class TransactionsJoinUsersReponse
{
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
    private String name;
    private String surname;
    private String firstname;
    private String othername;
    private String ipaddress;
    private String usertype;
    private String email;
    private String matric;
    private String formnumber;
    private String appnumber;
    private String utme;
    private String last_seen;
    private String activesession;
    private boolean iscomplete;
    private boolean isactive;
    private boolean ischange;
    private boolean isadmitted;
    private LocalDateTime created_at;
}
