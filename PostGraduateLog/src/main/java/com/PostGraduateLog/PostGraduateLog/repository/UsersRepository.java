package com.PostGraduateLog.PostGraduateLog.repository;

import com.PostGraduateLog.PostGraduateLog.dto.UserApptypeJoinReponses;
import com.PostGraduateLog.PostGraduateLog.model.Users;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    @Query(value ="SELECT us.id as ID,us.utme as UTME,us.name, us.matricno,us.activesession,us.matric,us.email,us.appnumber,us.apptype,us.formnumber,us.guid,us.ipaddress,us.isactive,us.isadmitted,us.ischange,us.iscomplete,us.ispaid, " +
            "rg.address,rg.admissionyear,rg.admissiotype,rg.category1,rg.category2,rg.changeprogramme, rg.department,rg.departmentid,rg.dob,rg.faculty,rg.created_at, rg.surname, rg.firstname,rg.othername,rg.psurname,rg.pfirstname,rg.pemail, " +
            "rg.paddress, rg.relation, rg.pphone, rg.sname, rg.saddress,rg.sphone,rg.semail, rg.session" +
            " FROM Users us  JOIN u_g_pre_admission_regs rg ON us.matricno = rg.matricno WHERE us.apptype=:apptype",nativeQuery = true)
    List<UserDisplayInterface> findUsersByApptype(@Param("apptype") String appt);

    @Query(value ="SELECT us.id as ID,us.utme as UTME,us.name, us.matricno,us.activesession,us.matric,us.email,us.appnumber,us.apptype,us.formnumber,us.guid,us.ipaddress,us.isactive,us.isadmitted,us.ischange,us.iscomplete,us.ispaid, " +
            "rg.address,rg.admissionyear,rg.admissiotype,rg.category1,rg.category2,rg.changeprogramme, rg.department,rg.departmentid,rg.dob,rg.faculty,rg.created_at, rg.surname, rg.firstname,rg.othername,rg.psurname,rg.pfirstname,rg.pemail, " +
            "rg.paddress, rg.relation, rg.pphone, rg.sname, rg.saddress,rg.sphone,rg.semail, rg.session" +
            " FROM Users us  JOIN u_g_pre_admission_regs rg ON us.matricno = rg.matricno WHERE us.apptype=:apptype AND us.activesession=:sess",nativeQuery = true)
    List<UserDisplayInterface> findDataByApptypeSession(@Param("apptype") String appt, @Param("sess") String sess);



    @Query(value ="SELECT id,utme,name,last_seen, firstname,surname,othername, matricno,activesession,matric,email,appnumber,apptype,formnumber,guid,ipaddress,isactive,isadmitted,ischange,iscomplete,ispaid,created_at,status,updated_at,usertype  FROM Users  WHERE apptype=:apptype", nativeQuery = true)
    List<Users> findByApptypeQuery(@Param("apptype") String appt);
    List<Users> findByApptype(String prog);
    List<Users> findByActivesession(String sess);
    List<Users> findByApptypeAndActivesession(String sess,String prog);
    List<Users> findByApptypeAndActivesessionAndIscomplete(String sess,String prog, boolean iscomp);

}
