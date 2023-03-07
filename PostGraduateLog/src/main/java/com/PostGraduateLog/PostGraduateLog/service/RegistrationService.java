package com.PostGraduateLog.PostGraduateLog.service;

import com.PostGraduateLog.PostGraduateLog.reponses.RegistrationResponse;
import com.PostGraduateLog.PostGraduateLog.model.Registrations;
import com.PostGraduateLog.PostGraduateLog.interfaces.RegistrationDisplayInterface;
import com.PostGraduateLog.PostGraduateLog.repository.ReqistrationRepository;
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
public class RegistrationService {
    private final ReqistrationRepository reqistrationRepository;
    public Page<Registrations> getRegistrationPagination(Integer pageNumber, Integer pageSize, String sortProperty) {
//      Sort sort = Sort.by(Sort.Direction.ASC,"name");
        Pageable pageable= null;
        if(null!=sortProperty)
        {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
        }
        else
        {
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        return reqistrationRepository.findAll(pageable);
    }

    public int UpdateUserSession(String ses, String email)
    {
        return reqistrationRepository.UpdateUserSession(ses, email);
    }
    public int UpdateUsersName(String sname, String fname, String oname,String email)
    {
        return reqistrationRepository.UpdateUsersName(sname,fname,oname, email);
    }

    public Registrations getUserByReg(String email)
    {
        return reqistrationRepository.findByEmail(email);
    }
    public List<RegistrationResponse> getRegistrationByAdmissiontype(String admtype)
    {
        return  reqistrationRepository.findByAdmissiontype(admtype).stream()
                .map(res -> mapToReportResponse(res)).toList();
    }
    private RegistrationResponse mapToReportResponse(Registrations registrations){
        return RegistrationResponse.builder()
                .id(registrations.getId())
                .matric(registrations.getMatric())
                .matricno(registrations.getMatricno())
                .utme(registrations.getUtme())
                .admissiontype(registrations.getAdmissiontype())
                .created_at(registrations.getCreated_at())
                .email(registrations.getEmail())
                .surname(registrations.getSurname())
                .firstname(registrations.getFirstname())
                .othername(registrations.getOthername())
                .guid(registrations.getGuid())
                .status(registrations.getStatus())
                .changeprogramme(registrations.getChangeprogramme())
                .state(registrations.getState())
                .lga(registrations.getLga())
                .town(registrations.getTown())
                .phone(registrations.getPhone())
                .category1(registrations.getCategory1())
                .category2(registrations.getCategory2())
                .updated_at(registrations.getUpdated_at())
                .session(registrations.getSession())
                .gender(registrations.getGender())
                .maritalstatus(registrations.getMaritalstatus())
                .address(registrations.getAddress())
                .admissionyear(registrations.getAdmissionyear())
                .department(registrations.getDepartment())
                .departmentid(registrations.getDepartmentid())
                .dob(registrations.getDob())
                .faculty(registrations.getFaculty())
                .level(registrations.getLevel())
                .mode(registrations.getMode())
                .mode(registrations.getMode())
                .programmeid(registrations.getProgrammeid())
                .photo(registrations.getPhoto())
                .religion(registrations.getReligion())
                .psurname(registrations.getPsurname())
                .paddress(registrations.getPaddress())
                .pemail(registrations.getPemail())
                .pfirstname(registrations.getPfirstname())
                .pphone(registrations.getPphone())
                .relation(registrations.getRelation())
                .saddress(registrations.getSaddress())
                .semail(registrations.getSemail())
                .sname(registrations.getSname())
                .sphone(registrations.getSphone())
                .build();
    }

    public List<RegistrationDisplayInterface> getRegistrationByAdmissionType(String admtype)
    {
        return reqistrationRepository.fetchRegistrationByAdmissionType(admtype);
    }
    public List<RegistrationDisplayInterface> getPGRegistration(String ses)
    {
        return reqistrationRepository.fetchPGRegistration(ses);
    }
    public List<RegistrationDisplayInterface> getUGDRegistration(String ses, String admtype)
    {
        return reqistrationRepository.fetchUGDRegistration(ses, admtype);
    }
    public  RegistrationDisplayInterface getPGUserRegistrationByEmail(String email)
    {
        return  reqistrationRepository.getPGRegistrationByEmail(email);
    }
    public  RegistrationDisplayInterface getUGDUserRegistrationByEmail(String email)
    {
        return  reqistrationRepository.getUGDRegistrationByEmail(email);
    }
}
