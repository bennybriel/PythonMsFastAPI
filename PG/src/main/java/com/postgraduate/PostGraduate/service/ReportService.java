package com.postgraduate.PostGraduate.service;

import com.postgraduate.PostGraduate.dto.ReportRequest;
import com.postgraduate.PostGraduate.dto.ReportResponse;
import com.postgraduate.PostGraduate.model.Report;
import com.postgraduate.PostGraduate.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportService {

    private  final ReportRepository reportRepository;
    public void createReport(ReportRequest reportRequest)
    {
        Report report = Report.builder()
                        .description(reportRequest.getDescription())
                        .apptype(reportRequest.getApptype())
                        .amount(reportRequest.getAmount())
                        .name(reportRequest.getName())
                        .matricno(reportRequest.getMatricno())
                        .build();

        reportRepository.save(report);
        log.info("Report  " + report.getId() +" is saved");
        log.info("Report  {} is saved", report.getId());
    }

    public List<ReportResponse> getAllReports()
    {
      List<Report> reports =  reportRepository.findAll();
      return reports.stream().map(report -> mapToReportResponse(report)).toList();
    }
    private ReportResponse  mapToReportResponse(Report report){
        return ReportResponse.builder()
                .id(report.getId())
                .name(report.getName())
                .matricno(report.getMatricno())
                .description(report.getDescription())
                .apptype(report.getApptype())
                .amount(report.getAmount())
                .build();
    }
}
