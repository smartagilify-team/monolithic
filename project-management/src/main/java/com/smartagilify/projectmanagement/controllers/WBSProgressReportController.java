package com.smartagilify.projectmanagement.controllers;

import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.wbsprogressreport.WBSProgressReportMapper;
import com.smartagilify.projectmanagement.model.dtos.WBSProgressReportDTO;
import com.smartagilify.projectmanagement.model.entities.WBSProgressReport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestAddress.WBS_PROGRESS_REPORT)
public class WBSProgressReportController extends BaseController<WBSProgressReport, WBSProgressReportMapper, WBSProgressReportDTO> {

    public WBSProgressReportController(BaseService<WBSProgressReport, WBSProgressReportMapper, WBSProgressReportDTO> service) {
        super(service);
    }
}
