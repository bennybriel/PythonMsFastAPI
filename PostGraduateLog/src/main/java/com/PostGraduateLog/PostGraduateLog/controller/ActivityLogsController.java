package com.PostGraduateLog.PostGraduateLog.controller;

import com.PostGraduateLog.PostGraduateLog.dto.ActivityLogResponse;
import com.PostGraduateLog.PostGraduateLog.dto.ActivityRequest;
import com.PostGraduateLog.PostGraduateLog.dto.UsersResponse;
import com.PostGraduateLog.PostGraduateLog.service.ActivityLogService;
import com.PostGraduateLog.PostGraduateLog.service.UsersService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activitylog")
@RequiredArgsConstructor
@Tag(name="Activity Logs for Log All User Operations")

public class ActivityLogsController {
    private  final ActivityLogService activityLogService;
    private final UsersService usersService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String logActivities(@RequestBody ActivityRequest activityRequest)
    {
        activityLogService.logActivities(activityRequest);
        return "Activities Logged Successfully";
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ActivityLogResponse> getAllLogs()
    {
        return activityLogService.getAllLogs();
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public List<ActivityLogResponse> getLogsByUsername(@PathVariable("username") String userName)
    {
         return activityLogService.getLogsByUsername(userName);
    }

    @GetMapping("/{prog}")
    @ResponseStatus(HttpStatus.OK)
    public List<UsersResponse> getUsersByProgramme(@PathVariable("prog") String prog)
    {
        return usersService.getUsersByProgramme(prog);
    }

}
