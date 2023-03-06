package com.postgraduate.PostGraduate.controller;

import com.postgraduate.PostGraduate.dto.ReportResponse;
import com.postgraduate.PostGraduate.model.Report;
import com.postgraduate.PostGraduate.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.postgraduate.PostGraduate.dto.ReportRequest;

import java.util.List;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {
    private  final ReportService reportService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void createReport(@RequestBody ReportRequest productRequest)
    {
        reportService.createReport(productRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReportResponse> getAllReports()
    {
       return reportService.getAllReports();
    }

}
