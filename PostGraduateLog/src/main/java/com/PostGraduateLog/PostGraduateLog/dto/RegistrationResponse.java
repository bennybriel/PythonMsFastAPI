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
public class RegistrationResponse {
    private long id;
    private String matricno;
    private String surname;
    private String firstname;
    private String othername;
    private String state;
    private String lga;
    private String guid;
    private String matric;
    private String town;
    private String changeprogramme;
    private String utme;
    private String phone;
    private LocalDateTime dob;
    private String category1;
    private String category2;
    private String session;
    private String gender;
    private String maritalstatus;
    private String address;
    private String photo;
    private String religion;
    private String faculty;
    private String department;
    private String mode;
    private String psurname;
    private String pfirstname;
    private String paddress;
    private String pemail;
    private String pphone;
    private String relation;
    private String sname;
    private String saddress;
    private String sphone;
    private String semail;
    private String admissionyear;
    private String admissiotype;
    private Integer programmeid;
    private Integer departmentid;
    private Integer level;
    private Boolean status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
