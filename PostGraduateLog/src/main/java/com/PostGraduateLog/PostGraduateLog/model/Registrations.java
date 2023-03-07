package com.PostGraduateLog.PostGraduateLog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Struct;
import java.time.LocalDateTime;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="u_g_pre_admission_regs")
public class Registrations {

    @Id
    @GeneratedValue
    private long id;
    private String matricno;
    private String surname;
    private String firstname;
    private String othername;
    private String email;
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
    private String admissiontype;
    private Integer programmeid;
    private Integer departmentid;
    private Integer level;
    private Boolean status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
