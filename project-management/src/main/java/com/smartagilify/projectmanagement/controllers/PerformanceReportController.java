package com.smartagilify.projectmanagement.controllers;

import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.performancereport.PerformanceReportMapper;
import com.smartagilify.projectmanagement.model.dtos.PerformanceReportDTO;
import com.smartagilify.projectmanagement.model.entities.PerformanceReport;
import com.smartagilify.projectmanagement.services.performancereport.PerformanceReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(RestAddress.PERFORMANCE_REPORT)
public class PerformanceReportController extends BaseController<PerformanceReport, PerformanceReportMapper, PerformanceReportDTO> {

    private final PerformanceReportService performanceReportService;

    public PerformanceReportController(BaseService<PerformanceReport, PerformanceReportMapper, PerformanceReportDTO> service, PerformanceReportService performanceReportService) {
        super(service);
        this.performanceReportService = performanceReportService;
    }
}
