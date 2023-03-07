package com.PostGraduateLog.PostGraduateLog.repository;

import com.PostGraduateLog.PostGraduateLog.interfaces.RegistrationDisplayInterface;
import com.PostGraduateLog.PostGraduateLog.model.Registrations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReqistrationRepository extends JpaRepository<Registrations, String> {
    Registrations findByEmail(String email);
    List<Registrations> findByAdmissiontype(String admtype);

    @Query(value = "SELECT rg.*, pg.programme, pg.degree FROM u_g_pre_admission_regs rg INNER JOIN pgprogramme pg ON rg.category1 = pg.programmeid WHERE rg.admissiontype=:admtype", nativeQuery = true)
    List<RegistrationDisplayInterface> fetchRegistrationByAdmissionType(@Param("admtype") String admtype);

    @Query(value = "SELECT rg.*, ad.name as programme FROM u_g_pre_admission_regs rg INNER JOIN admissionprogrammes ad ON rg.category1 = ad.programmeid WHERE rg.session=:ses AND  rg.admissiontype=:admtype", nativeQuery = true)
    List<RegistrationDisplayInterface> fetchUGDRegistration(@Param("ses") String ses, @Param("admtype") String admtype);

    @Query(value = "SELECT rg.*, ad.name as programme FROM u_g_pre_admission_regs rg INNER JOIN admissionprogrammes ad ON rg.category1 = ad.programmeid WHERE rg.email=:email", nativeQuery = true)
    RegistrationDisplayInterface getUGDRegistrationByEmail(@Param("email") String email);

    @Query(value = "SELECT rg.*, pg.programme, pg.degree FROM u_g_pre_admission_regs rg INNER JOIN pgprogramme pg ON rg.category1 = pg.programmeid WHERE rg.session=:ses", nativeQuery = true)
    List<RegistrationDisplayInterface> fetchPGRegistration(@Param("ses") String ses);

    @Query(value = "SELECT rg.*, pg.programme, pg.degree FROM u_g_pre_admission_regs rg INNER JOIN pgprogramme pg ON rg.category1 = pg.programmeid WHERE rg.email=:email", nativeQuery = true)
    RegistrationDisplayInterface getPGRegistrationByEmail(@Param("email") String email);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Registrations rg  SET rg.session=:ses WHERE rg.email =:email")
    int UpdateUserSession(@Param("ses") String ses, @Param("email") String email);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Registrations rg  SET rg.surname=:sname, rg.firstname=:fname, rg.othername=:oname WHERE rg.email=:email")
    int UpdateUsersName(@Param("sname") String sname, @Param("fname") String fname, @Param("oname") String oname,@Param("email") String email);


}
