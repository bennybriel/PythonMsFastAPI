package com.PostGraduateLog.PostGraduateLog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Users {

    @Id
    @GeneratedValue
//    @JoinColumn(name = "matricno", referencedColumnName = "matricno")
//    private Set<u_g_pre_admission_regsEntity> preAdmission;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatricno() {
        return matricno;
    }

    public void setMatricno(String matricno) {
        this.matricno = matricno;
    }

    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMatric() {
        return matric;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public String getFormnumber() {
        return formnumber;
    }

    public void setFormnumber(String formnumber) {
        this.formnumber = formnumber;
    }

    public String getAppnumber() {
        return appnumber;
    }

    public void setAppnumber(String appnumber) {
        this.appnumber = appnumber;
    }

    public String getUtme() {
        return utme;
    }

    public void setUtme(String utme) {
        this.utme = utme;
    }

    public String getLast_seen() {
        return last_seen;
    }

    public void setLast_seen(String last_seen) {
        this.last_seen = last_seen;
    }

    public String getActivesession() {
        return activesession;
    }

    public void setActivesession(String activesession) {
        this.activesession = activesession;
    }

    public boolean isIspaid() {
        return ispaid;
    }

    public void setIspaid(boolean ispaid) {
        this.ispaid = ispaid;
    }

    public boolean isIscomplete() {
        return iscomplete;
    }

    public void setIscomplete(boolean iscomplete) {
        this.iscomplete = iscomplete;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isIschange() {
        return ischange;
    }

    public void setIschange(boolean ischange) {
        this.ischange = ischange;
    }

    public boolean isIsadmitted() {
        return isadmitted;
    }

    public void setIsadmitted(boolean isadmitted) {
        this.isadmitted = isadmitted;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", matricno='" + matricno + '\'' +
                ", apptype='" + apptype + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", othername='" + othername + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                ", usertype='" + usertype + '\'' +
                ", email='" + email + '\'' +
                ", guid='" + guid + '\'' +
                ", matric='" + matric + '\'' +
                ", formnumber='" + formnumber + '\'' +
                ", appnumber='" + appnumber + '\'' +
                ", utme='" + utme + '\'' +
                ", last_seen='" + last_seen + '\'' +
                ", activesession='" + activesession + '\'' +
                ", ispaid=" + ispaid +
                ", iscomplete=" + iscomplete +
                ", isactive=" + isactive +
                ", status=" + status +
                ", ischange=" + ischange +
                ", isadmitted=" + isadmitted +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
