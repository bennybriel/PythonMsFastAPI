package com.PostGraduateLog.PostGraduateLog.controller;

import com.PostGraduateLog.PostGraduateLog.dto.*;
import com.PostGraduateLog.PostGraduateLog.model.Users;
import com.PostGraduateLog.PostGraduateLog.repository.UserDisplayInterface;
import com.PostGraduateLog.PostGraduateLog.service.UsersService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;

@RestController
@RequiredArgsConstructor
@SecurityScheme(name = "jwtBearerAuth",type = SecuritySchemeType.HTTP)
@Tag(name="Users Controller for All Users")
public class UsersController {
    private final UsersService usersService;

    @ApiResponses(
                value  = {
                           @ApiResponse(description = "Record Fetched Successfully", responseCode = "201"),
                           @ApiResponse(description = "No Record Found", responseCode = "403")
                         }
                 )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsersResponse> getAllLogs()
    {
        return usersService.getAllLogs();
    }

    @GetMapping("/{prog}")
    @ResponseStatus(HttpStatus.OK)
    public List<UsersResponse> getUsersByProgramme(@PathVariable("prog") String prog)
    {
        return usersService.getUsersByProgramme(prog);
    }
    @RequestMapping("/api/v1/mmusers")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsersResponse> getUsersByApSesIsCom(@RequestBody UserAppSessionIsCompleteRequest userRequest)
    {
        return usersService.getUsersByApptypeSessionIsComplete(userRequest.getActivesession(),
                userRequest.getApptype(), userRequest.isIscomplete());
    }
    @RequestMapping("/api/v1/musers")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsersResponse>getUsersByApptypeSession(@RequestBody UserByAppSessionRequest userRequest)
    {
        return usersService.getUsersByAppTypeAndSession(userRequest.getActivesession(),userRequest.getApptype());
    }
    @RequestMapping("/api/v1/users")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsersResponse> getUsersBySession(@RequestBody UserRequest userRequest)
    {
        return usersService.getUsersBySession(userRequest.getActivesession());
    }
    @RequestMapping(value = "/api/v1/pagingAndSortingUser/{pageNumber}/{pageSize}", method =RequestMethod.GET)
    public Page<Users> userPagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize)
    {
        return usersService.getUserPagination(pageNumber,pageSize,null);
    }

    @RequestMapping(value = "/api/v1/pagingAndSortingUser/{pageNumber}/{pageSize}/{sortProperty}", method =RequestMethod.GET)
    public Page<Users> userPagination(@PathVariable Integer pageNumber,
                                      @PathVariable Integer pageSize,
                                      @PathVariable String sortProperty)
    {
        return usersService.getUserPagination(pageNumber,pageSize, sortProperty);
    }

    @RequestMapping("/api/v1/userApptype/{apptype}")
    public List<Users> userByApptype(@PathVariable String apptype)
    {
        return usersService.userByApptype(apptype);
    }

    @RequestMapping("/api/v1/userRegAppType/{apptype}")
    public List<UserDisplayInterface> getUserRegByApptype(@PathVariable String apptype)
    {
        return usersService.getUserRegByApptype(apptype);
    }

    @RequestMapping("/api/v1/userDataByAppSession")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDisplayInterface>getDataByApptypeSession(@RequestBody UserByAppSessionRequest userByAppSessionRequest)
    {
        return  usersService.getDataByApptypeSession(userByAppSessionRequest.getApptype(), userByAppSessionRequest.getActivesession());
    }
}
