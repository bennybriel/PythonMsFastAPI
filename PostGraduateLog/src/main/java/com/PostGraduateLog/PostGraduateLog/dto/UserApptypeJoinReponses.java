package com.PostGraduateLog.PostGraduateLog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.tuple.entity.EntityBasedAssociationAttribute;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserApptypeJoinReponses
{
    private long id;
    private String apptype;
    private String formnumber;
    private String appnumber;
    private String usertype;
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
    private String activesession;
    private LocalDateTime dob;
    private String category1;
    private String category2;
    private String session;
    private String gender;
    private String maritalstatus;
    private String address;
    private String photo;
    private String email;
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
    private  Boolean ispaid;
    private Boolean isactive;
    private Boolean ischange;
    private Boolean isadmitted;
    private Boolean iscomplete;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public UserApptypeJoinReponses(String matric, String matricno, String utme, String email, String lga, String state)
    {
        this.matric = matric;
        this.matricno = matricno;
        this.utme = utme;
        this.email = email;
        this.lga = lga;
        this.state = state;
    }
    @Override
    public String toString() {
        return "UserApptypeJoinReponses [matric=" + matric + ", matricno=" + matricno + ", utme=" + utme + ", email="
                + email + ",  lga=" + lga +", state=" + state +"]";
    }

}
