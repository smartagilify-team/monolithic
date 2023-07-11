package com.smartagilify.projectmanagement.services.performancereport;

import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.performancereport.PerformanceReportMapper;
import com.smartagilify.projectmanagement.model.dtos.PerformanceReportDTO;
import com.smartagilify.projectmanagement.model.entities.PerformanceReport;
import com.smartagilify.projectmanagement.repositories.performancereport.PerformanceReportRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PerformanceReportServiceImpl extends
        BaseService<PerformanceReport, PerformanceReportMapper, PerformanceReportDTO> implements PerformanceReportService {

    private final PerformanceReportRepository performanceReportRepository;

    public PerformanceReportServiceImpl(JpaRepository<PerformanceReport, Long> jpaRepository, PerformanceReportRepository performanceReportRepository) {
        super(jpaRepository);
        this.performanceReportRepository = performanceReportRepository;
    }

    @Override
    protected Class<PerformanceReportMapper> getMapper() {
        return PerformanceReportMapper.class;
    }
}
