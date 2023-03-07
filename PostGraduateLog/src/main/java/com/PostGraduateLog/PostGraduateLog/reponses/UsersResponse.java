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

public class UsersResponse {
    private long id;
    private String matricno;
    private String apptype;
    private String name;
    private String surname;
    private String firstname;
    private String othername;
    private String ipaddress;
    private String usertype;
    private String email;
    private String guid;
    private String matric;
    private String formnumber;
    private String appnumber;
    private String utme;
    private String last_seen;
    private String activesession;
    private boolean ispaid;
    private boolean iscomplete;
    private boolean isactive;
    private boolean status;
    private boolean ischange;
    private boolean isadmitted;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
