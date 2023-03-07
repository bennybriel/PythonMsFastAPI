package com.PostGraduateLog.PostGraduateLog.controller;

import com.PostGraduateLog.PostGraduateLog.reponses.RegistrationResponse;
import com.PostGraduateLog.PostGraduateLog.dto.*;
import com.PostGraduateLog.PostGraduateLog.model.Registrations;
import com.PostGraduateLog.PostGraduateLog.interfaces.RegistrationDisplayInterface;
import com.PostGraduateLog.PostGraduateLog.service.RegistrationService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@SecurityScheme(name = "jwtBearerAuth",type = SecuritySchemeType.HTTP)
@Tag(name="Registration Controller For  Completed Applications")

public class RegistrationController
{
    private final RegistrationService registrationService;

    @RequestMapping(value = "/api/v1/getAllRegistrations/{pageNumber}/{pageSize}/{sortProperty}", method = RequestMethod.GET)
    public Page<Registrations> registrationPagination(@PathVariable Integer pageNumber,
                                                      @PathVariable Integer pageSize,
                                                      @PathVariable String sortProperty)
    {
        return registrationService.getRegistrationPagination(pageNumber,pageSize, sortProperty);
    }

    @RequestMapping(value = "/api/v1/getAllRegistrations/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public Page<Registrations> registrationPagination(@PathVariable Integer pageNumber,
                                                      @PathVariable Integer pageSize
                                                    )
    {
        return registrationService.getRegistrationPagination(pageNumber,pageSize, null);
    }
    @GetMapping("/api/v1/getUsersRegByEmail/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Registrations getUserRegByEmail(@PathVariable("email") String email)
    {
        return registrationService.getUserByReg(email);
    }
    @RequestMapping("/api/v1/userRegByAdmissiontype/{admtype}")
    public List<RegistrationResponse> getUserRegByAdmissiontype(@PathVariable String admtype)
    {
        return registrationService.getRegistrationByAdmissiontype(admtype);
    }
    @RequestMapping("/api/v1/userRegByAdmissionTypes/{admtype}")
    public List<RegistrationDisplayInterface> getRegistrationByAdmissionType(@PathVariable String admtype)
    {
        return registrationService.getRegistrationByAdmissionType(admtype);
    }
    @RequestMapping("/api/v1/userPGRegistration")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RegistrationDisplayInterface> getPGRegistration(@RequestBody RegistrationSessionRequest registrationSessionRequest)
    {
        return registrationService.getPGRegistration(registrationSessionRequest.getSession());
    }

    @RequestMapping("/api/v1/userUGDRegistration")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RegistrationDisplayInterface> getUGDRegistration(@RequestBody RegistrationSessionAdmissionTypeRequest registrationSessionAdmissionTypeRequest)
    {
        return registrationService.getUGDRegistration(registrationSessionAdmissionTypeRequest.getSession(), registrationSessionAdmissionTypeRequest.getAdmissiontype());
    }
    @RequestMapping("/api/v1/userPGRegistrationByEmail/{email}")
    public RegistrationDisplayInterface getPGRegistrationByEmail(@PathVariable String email)
    {
        return registrationService.getPGUserRegistrationByEmail(email);
    }

    @RequestMapping("/api/v1/userUGDRegistrationByEmail/{email}")
    public RegistrationDisplayInterface getUGDRegistrationByEmail(@PathVariable String email)
    {
        return registrationService.getUGDUserRegistrationByEmail(email);
    }

}

