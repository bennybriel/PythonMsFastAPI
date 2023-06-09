package com.PostGraduateLog.PostGraduateLog.repository;

import com.PostGraduateLog.PostGraduateLog.interfaces.RegistrationDisplayInterface;
import com.PostGraduateLog.PostGraduateLog.model.Registrations;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReqistrationRepository extends JpaRepository<Registrations, String> {
    Registrations findByEmail(String email);

    List<Registrations> findByAdmissiontype(String admtype);

    @Query(value = "SELECT rg.*, pg.programme, pg.degree FROM u_g_pre_admission_regs rg INNER JOIN pgprogramme pg ON rg.category1 = pg.programmeid WHERE rg.admissiontype=:admtype", nativeQuery = true)
    List<RegistrationDisplayInterface> fetchRegistrationByAdmissionType(@Param("admtype") String admtype);
    /*
     * FILTER BY UTME STATE
     * */
    @Query(value = "SELECT rg.*, ad.name as programme FROM u_g_pre_admission_regs rg INNER JOIN admissionprogrammes ad ON rg.category1 = ad.programmeid WHERE rg.session=:ses AND  rg.admissiontype=:admtype", nativeQuery = true)
    List<RegistrationDisplayInterface> fetchUGDRegistration(@Param("ses") String ses, @Param("admtype") String admtype);
    @Query(value = "SELECT rg.*, ad.name as programme FROM u_g_pre_admission_regs rg INNER JOIN admissionprogrammes ad ON rg.category1 = ad.programmeid WHERE rg.email=:email", nativeQuery = true)
    RegistrationDisplayInterface getUGDRegistrationByEmail(@Param("email") String email);

    @Query(value = "SELECT rg.*, ad.name as programme FROM u_g_pre_admission_regs rg INNER JOIN admissionprogrammes ad ON rg.category1 = ad.programmeid WHERE admissiontype=:admtype AND  state=:state", nativeQuery = true)
    List<RegistrationDisplayInterface> filterUGDRegistrationStateAdmissionType(@Param("admtype") String admtype, @Param("state") String state);

    @Query(value = "SELECT rg.*, ad.name as programme FROM u_g_pre_admission_regs rg INNER JOIN admissionprogrammes ad ON rg.category1 = ad.programmeid WHERE (rg.admissiontype='DE' OR rg.admissiontype='UTME' OR rg.admissiontype='UGD') AND state=:state", nativeQuery = true)
    List<RegistrationDisplayInterface> filterUGDRegistrationByState(@Param("state") String state);

    @Query(value = "SELECT rg.*, ad.name as programme FROM u_g_pre_admission_regs rg INNER JOIN admissionprogrammes ad ON rg.category1 = ad.programmeid WHERE state=:state AND  session =:ses", nativeQuery = true)
    List<RegistrationDisplayInterface> filterUGDRegistrationStateSession(@Param("state") String state,@Param("ses") String ses);
    /*
    * FILTER BY PG STATE
    * */
    @Query(value = "SELECT rg.*, pg.programme, pg.degree FROM u_g_pre_admission_regs rg INNER JOIN pgprogramme pg ON " +
            "rg.category1 = pg.programmeid WHERE rg.state=:state AND admissiontype='PG'", nativeQuery = true)
    List<RegistrationDisplayInterface> filterPGRegistrationByState(@Param("state") String state);

    @Query(value = "SELECT rg.*, pg.programme, pg.degree FROM u_g_pre_admission_regs rg INNER JOIN pgprogramme pg ON " +
            "rg.category1 = pg.programmeid WHERE rg.state=:state AND admissiontype='PG' AND session=:ses", nativeQuery = true)
    List<RegistrationDisplayInterface> filterPGRegistrationByStateSession(@Param("state") String state, @Param("ses") String ses);

    @Query(value = "SELECT rg.*, pg.programme, pg.degree FROM u_g_pre_admission_regs rg INNER JOIN pgprogramme pg ON rg.category1 = pg.programmeid WHERE rg.session=:ses", nativeQuery = true)
    List<RegistrationDisplayInterface> fetchPGRegistration(@Param("ses") String ses);

    @Query(value = "SELECT rg.*, pg.programme, pg.degree FROM u_g_pre_admission_regs rg INNER JOIN pgprogramme pg ON rg.category1 = pg.programmeid WHERE rg.email=:email", nativeQuery = true)
    RegistrationDisplayInterface getPGRegistrationByEmail(@Param("email") String email);
    /*
    * UPDATE PROGRAMME, PHONE, DOB, MATRIC
    * */
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Registrations SET phone=:phone, category1=:category,matric=:matric WHERE email =:email")
    int UpdateRegistrationInfo(@Param("email") String email, @Param("phone") String phone,
                               @Param("category") String category, @Param("matric") String matric);
    /*
     * UPDATE STATE, LGA
     * */
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Registrations SET lga=:lga, state=:state WHERE email =:email")
    int UpdateStateLga(@Param("email") String email, @Param("lga") String lga, @Param("state") String state);
    /*
    * UPDATE SURNAME, FIRSTNAME, OTHERNAME
    * */
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Registrations rg  SET rg.session=:ses WHERE rg.email =:email")
    int UpdateUserSession(@Param("ses") String ses, @Param("email") String email);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Registrations rg  SET rg.surname=:sname, rg.firstname=:fname, rg.othername=:oname WHERE rg.email=:email")
    int UpdateUsersName(@Param("sname") String sname, @Param("fname") String fname, @Param("oname") String oname,@Param("email") String email);

    @Query(value = "SELECT rg.*, ad.name as programme FROM u_g_pre_admission_regs rg INNER JOIN admissionprogrammes ad ON rg.category1 = ad.programmeid WHERE admissionyear=:admyear", nativeQuery = true)
    List<RegistrationDisplayInterface> fetchRegistrationByAdmissionYear(@Param("admyear") String admyear);

    @Query(value = "SELECT rg.*, ad.name as programme FROM u_g_pre_admission_regs rg INNER JOIN admissionprogrammes ad ON rg.category1 = ad.programmeid WHERE admissionyear=:admyear AND session=:ses", nativeQuery = true)
    List<RegistrationDisplayInterface> fetchRegistrationByAdmissionYearSession(@Param("admyear") String admyear, @Param("ses") String ses);

    @Query(value = "SELECT rg.*, ad.name as programme FROM u_g_pre_admission_regs rg INNER JOIN admissionprogrammes ad ON rg.category1 = ad.programmeid WHERE admissionyear=:admyear AND session=:ses AND admissiontype=:admtype", nativeQuery = true)
    List<RegistrationDisplayInterface> fetchRegistrationByAdmissionYearSessionAdmType(@Param("admyear") String admyear, @Param("ses") String ses, @Param("admtype") String admtype);

}
