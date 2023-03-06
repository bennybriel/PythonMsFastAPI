package com.PostGraduateLog.PostGraduateLog.controller;

import com.PostGraduateLog.PostGraduateLog.dto.UsersResponse;
import com.PostGraduateLog.PostGraduateLog.model.Registrations;
import com.PostGraduateLog.PostGraduateLog.model.Users;
import com.PostGraduateLog.PostGraduateLog.service.RegistrationService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.PostGraduateLog.PostGraduateLog.repository.ReqistrationRepository;
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
}
