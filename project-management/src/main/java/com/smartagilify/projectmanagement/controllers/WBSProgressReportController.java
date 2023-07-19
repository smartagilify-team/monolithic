package com.smartagilify.projectmanagement.controllers;

import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.wbsprogressreport.WBSProgressReportMapper;
import com.smartagilify.projectmanagement.model.dtos.WBSProgressReportDTO;
import com.smartagilify.projectmanagement.model.entities.WBSProgressReport;
import com.smartagilify.projectmanagement.services.wbsprogressreport.WBSProgressReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(RestAddress.WBS_PROGRESS_REPORT)
public class WBSProgressReportController extends BaseController<WBSProgressReport, WBSProgressReportMapper, WBSProgressReportDTO> {

    private final WBSProgressReportService wbsProgressReportService;

    public WBSProgressReportController(BaseService<WBSProgressReport, WBSProgressReportMapper, WBSProgressReportDTO> service, WBSProgressReportService wbsProgressReportService) {
        super(service);
        this.wbsProgressReportService = wbsProgressReportService;
    }
}
