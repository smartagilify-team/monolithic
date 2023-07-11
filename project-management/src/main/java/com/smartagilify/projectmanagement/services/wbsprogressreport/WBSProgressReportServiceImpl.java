package com.smartagilify.projectmanagement.services.wbsprogressreport;

import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.wbsprogressreport.WBSProgressReportMapper;
import com.smartagilify.projectmanagement.model.dtos.WBSProgressReportDTO;
import com.smartagilify.projectmanagement.model.entities.WBSProgressReport;
import com.smartagilify.projectmanagement.repositories.wbsprogressreport.WBSProgressReportRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class WBSProgressReportServiceImpl extends
        BaseService<WBSProgressReport, WBSProgressReportMapper, WBSProgressReportDTO> implements WBSProgressReportService {
    private final WBSProgressReportRepository wbsProgressReportRepository;
    public WBSProgressReportServiceImpl(JpaRepository<WBSProgressReport, Long> jpaRepository, WBSProgressReportRepository wbsProgressReportRepository) {
        super(jpaRepository);
        this.wbsProgressReportRepository = wbsProgressReportRepository;
    }

    @Override
    protected Class<WBSProgressReportMapper> getMapper() {
        return WBSProgressReportMapper.class;
    }
}
