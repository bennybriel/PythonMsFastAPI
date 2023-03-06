package com.PostGraduateLog.PostGraduateLog.service;

import com.PostGraduateLog.PostGraduateLog.dto.ActivityLogResponse;
import com.PostGraduateLog.PostGraduateLog.dto.ActivityRequest;
import com.PostGraduateLog.PostGraduateLog.model.ActivityLog;
import com.PostGraduateLog.PostGraduateLog.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ActivityLogService {
    private  final ActivityLogRepository activityLogRepository;
    //private final WebClient webClient;
    public void logActivities(ActivityRequest activityRequest)
    {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setBrowser(activityRequest.getBrowser());
        activityLog.setGuid(UUID.randomUUID().toString());
        activityLog.setIpAddress(activityRequest.getIpAddress());
        activityLog.setOperation(activityRequest.getOperation());
        activityLog.setPlatForm(activityRequest.getPlatForm());
        activityLog.setUserName(activityRequest.getUserName());
        activityLog.setMacAddress(activityRequest.getMacAddress());
        activityLogRepository.save(activityLog);

//        Boolean result = webClient.get()
//                    .uri("http://transcript.husried.com/api/v1/programmes")
//                    .retrieve()
//                    .bodyToMono(Boolean.class)
//                    .block();
//        if(result)
//        {
//            activityLogRepository.save(activityLog);
//        }
//        else
//        {
//            throw new IllegalArgumentException("No Country Found");
//        }





    }

    public List<ActivityLogResponse> getAllLogs()
    {
        List<ActivityLog> activities =  activityLogRepository.findAll();
        return activities.stream().map(activity -> mapToReportResponse(activity)).toList();
    }
    public List<ActivityLogResponse> getLogsByUsername(String userName)
    {
           //Optional<ActivityLog> activities =  activityLogRepository.findByUserName(userName);
                return  activityLogRepository.findByUserName(userName).stream()
                                              .map(activity -> mapToReportResponse(activity)).toList();

//        return  activityLogRepository.findByUserName(userName).stream()
//                                     .map(activity -> ActivityLogResponse.builder()
//                                              .id(activity.getId())
//                                              .browser(activity.getBrowser())
//                                              .guid(activity.getGuid())
//                                              .ipAddress(activity.getIpAddress())
//                                              .macAddress(activity.getMacAddress())
//                                              .operation(activity.getOperation())
//                                              .platForm(activity.getPlatForm())
//                                              .userName(activity.getUserName())
//                                              .build()
//                                      ).toList();
    }


    private ActivityLogResponse mapToReportResponse(ActivityLog activityLog){
        return ActivityLogResponse.builder()
                .id(activityLog.getId())
                .browser(activityLog.getBrowser())
                .guid(activityLog.getGuid())
                .ipAddress(activityLog.getIpAddress())
                .macAddress(activityLog.getMacAddress())
                .operation(activityLog.getOperation())
                .platForm(activityLog.getPlatForm())
                .userName(activityLog.getUserName())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
