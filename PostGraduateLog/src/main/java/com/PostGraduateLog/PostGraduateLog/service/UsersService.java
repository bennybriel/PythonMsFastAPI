package com.PostGraduateLog.PostGraduateLog.service;

import com.PostGraduateLog.PostGraduateLog.reponses.UserApptypeJoinReponses;
import com.PostGraduateLog.PostGraduateLog.dto.UserApptypeJoinRequest;
import com.PostGraduateLog.PostGraduateLog.reponses.UsersResponse;
import com.PostGraduateLog.PostGraduateLog.model.Users;
import com.PostGraduateLog.PostGraduateLog.interfaces.UserDisplayInterface;
import com.PostGraduateLog.PostGraduateLog.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersService {
    private  final UsersRepository usersRepository;
    public List<UsersResponse> getAllLogs()
    {
        List<Users> users =  usersRepository.findAll();
        return users.stream().map(user -> mapToReportResponse(user)).toList();
    }
    public Users getUsersByEmail(String email)
    {
        return  usersRepository.findByEmail(email);
    }
    public List<UsersResponse> getUsersByProgramme(String prog)
    {
        return  usersRepository.findByApptype(prog).stream()
                .map(user -> mapToReportResponse(user)).toList();
    }
    public List<UsersResponse> getUsersBySession(String sess)
    {
        return  usersRepository.findByActivesession(sess).stream()
                .map(user -> mapToReportResponse(user)).toList();
    }
    public List<UsersResponse> getUsersByAppTypeAndSession(String prog, String sess)
    {
        return  usersRepository.findByApptypeAndActivesession(sess,prog).stream()
                .map(user->mapToReportResponse(user)).toList();
    }
    public List<UsersResponse> getUsersByApptypeSessionIsComplete(String prog, String sess, boolean iscomp)
    {
;
        return  usersRepository.findByApptypeAndActivesessionAndIscomplete(sess,prog, iscomp).stream()
                .map(user->mapToReportResponse(user)).toList();
    }

    private UsersResponse mapToReportResponse(Users users){
        return UsersResponse.builder()
                .id(users.getId())
                .activesession(users.getActivesession())
                .appnumber(users.getAppnumber())
                .apptype(users.getApptype())
               // .created_at(users.getCreated_at())
                .email(users.getEmail())
                .firstname(users.getFirstname())
                .formnumber(users.getFormnumber())
                .guid(users.getGuid())
                .ipaddress(users.getIpaddress())
                .isactive(users.isIsactive())
                .isadmitted(users.isIsadmitted())
                .ischange(users.isIschange())
                .iscomplete(users.isIscomplete())
                .ispaid(users.isIspaid())
                .last_seen(users.getLast_seen())
                .matric(users.getMatric())
                .matricno(users.getMatricno())
                .name(users.getName())
                .othername(users.getOthername())
                .surname(users.getSurname())
                .usertype(users.getUsertype())
               // .updated_at(users.getUpdated_at())
                .utme(users.getUtme())
                .build();
    }

    public Page<Users> getUserPagination(Integer pageNumber, Integer pageSize, String sortProperty)
    {
        //Sort sort = Sort.by(Sort.Direction.ASC,"name");
        Pageable pageable= null;
        if(null!=sortProperty)
        {
            pageable = PageRequest.of(pageNumber, pageSize,Sort.Direction.ASC,sortProperty);
        }
        else
        {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "apptype");
        }
        return usersRepository.findAll(pageable);
    }
    public UserDisplayInterface getUserByRegistration(String email)
    {
        return  usersRepository.findUserRegistrationByEmail(email);
    }
    public List<Users> userByApptype(String appt)
    {
        Sort sort = Sort.by(Sort.Direction.ASC,"firstname");
        return  usersRepository.findByApptypeQuery(appt);
    }
    public List<UserDisplayInterface> getUserRegByApptype(String appt)
    {
          return   usersRepository.findUsersByApptype(appt);
    }
    public List<UserDisplayInterface> getDataByApptypeSession(String appt, String sess)
    {
        return   usersRepository.findDataByApptypeSession(appt, sess);
    }
    public int UpdateUserSession(String ses, String mat)
    {
       return usersRepository.UpdateUserSession(ses, mat);
    }

    public int UpdateUsersName(String sname, String fname, String oname,String email)
    {
        var name = sname + ' '+ fname + ' '+oname;
        return usersRepository.UpdateUsersName(name,sname,fname,oname, email);
    }
    public int UpdateUsersInfo(String appt,Boolean pad, String usr, Boolean adm, String frm, Boolean comp,
                               String mat, String appn, Boolean sta, Boolean isact, String email)
    {
        return usersRepository.UpdateUsersInfo(appt,pad,usr,adm,frm, comp, mat, appn,sta,isact, email);
    }
    private UserApptypeJoinReponses mapToReportRegResponse(UserApptypeJoinRequest res){
        return UserApptypeJoinReponses.builder()
                .id(res.getId())
                .admissionyear(res.getAdmissionyear())
                .address(res.getAddress())
                .email(res.getEmail())
                .category1(res.getCategory1())
                .category2(res.getCategory2())
                .changeprogramme(res.getChangeprogramme())
                .admissiotype(res.getAdmissiotype())
                .department(res.getDepartment())
                .departmentid(res.getDepartmentid())
                .dob(res.getDob())
                .faculty(res.getFaculty())
                .gender(res.getGender())
                .isactive(res.getIsactive())
                .isadmitted(res.getIsadmitted())
                .ischange(res.getIschange())
                .iscomplete(res.getIscomplete())
                .activesession(res.getActivesession())
                .appnumber(res.getAppnumber())
                .apptype(res.getApptype())
                .created_at(res.getCreated_at())
                .firstname(res.getFirstname())
                .formnumber(res.getFormnumber())
                .guid(res.getGuid())
                .matric(res.getMatric())
                .matricno(res.getMatricno())
                .othername(res.getOthername())
                .surname(res.getSurname())
                .usertype(res.getUsertype())
                .updated_at(res.getUpdated_at())
                .utme(res.getUtme())
                .build();
    }

}
