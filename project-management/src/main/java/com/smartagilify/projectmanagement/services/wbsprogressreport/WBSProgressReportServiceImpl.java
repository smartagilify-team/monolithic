package com.smartagilify.projectmanagement.services.wbsprogressreport;

import com.smartagilify.core.enumerations.EN_STATE;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.exceptions.ApplicationException;
import com.smartagilify.projectmanagement.mappers.wbsprogressreport.WBSProgressReportMapper;
import com.smartagilify.projectmanagement.model.dtos.WBSProgressReportDTO;
import com.smartagilify.projectmanagement.model.entities.PerformanceReport;
import com.smartagilify.projectmanagement.model.entities.WBS;
import com.smartagilify.projectmanagement.model.entities.WBSProgressReport;
import com.smartagilify.projectmanagement.repositories.performancereport.PerformanceReportRepository;
import com.smartagilify.projectmanagement.repositories.project.ProjectRepository;
import com.smartagilify.projectmanagement.repositories.wbs.WBSRepository;
import com.smartagilify.projectmanagement.repositories.wbsprogressreport.WBSProgressReportRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WBSProgressReportServiceImpl extends
        BaseService<WBSProgressReport, WBSProgressReportMapper, WBSProgressReportDTO> implements WBSProgressReportService {
    private final WBSProgressReportRepository wbsProgressReportRepository;
    private final PerformanceReportRepository performanceReportRepository;
    private final WBSRepository wbsRepository;

    public WBSProgressReportServiceImpl(JpaRepository<WBSProgressReport, Long> jpaRepository, WBSProgressReportRepository wbsProgressReportRepository, ProjectRepository projectRepository, PerformanceReportRepository performanceReportRepository, WBSRepository wbsRepository) {
        super(jpaRepository);
        this.wbsProgressReportRepository = wbsProgressReportRepository;
        this.performanceReportRepository = performanceReportRepository;
        this.wbsRepository = wbsRepository;
    }

    @Override
    protected Class<WBSProgressReportMapper> getMapper() {
        return WBSProgressReportMapper.class;
    }

    @Override
    public WBSProgressReportDTO save(WBSProgressReportDTO dto, Long userId) {
        WBSProgressReport entity = mapper.dto2Entity(dto);
        PerformanceReport performanceReport = performanceReportRepository
                .getReferenceById(dto.getPerformanceReportId());
        WBS wbs = wbsRepository.getReferenceById(dto.getWbsId());
        entity.setPerformanceReport(performanceReport);
        entity.setWbs(wbs); entity.setState(EN_STATE.CREATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(wbsProgressReportRepository.save(entity));
    }

    @Override
    public WBSProgressReportDTO update(WBSProgressReportDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        WBSProgressReport entity = mapper.dto2Entity(dto);
        PerformanceReport performanceReport = performanceReportRepository
                .getReferenceById(dto.getPerformanceReportId());
        WBS wbs = wbsRepository.getReferenceById(dto.getWbsId());
        entity.setPerformanceReport(performanceReport);
        entity.setWbs(wbs); entity.setState(EN_STATE.UPDATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(wbsProgressReportRepository.save(entity));
    }

    @Override
    public void softDelete(WBSProgressReportDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        WBSProgressReport entity = mapper.dto2Entity(dto);
        PerformanceReport performanceReport = performanceReportRepository
                .getReferenceById(dto.getPerformanceReportId());
        WBS wbs = wbsRepository.getReferenceById(dto.getWbsId());
        entity.setPerformanceReport(performanceReport);
        entity.setWbs(wbs); entity.setState(EN_STATE.DELETED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        mapper.entity2Dto(wbsProgressReportRepository.save(entity));
    }
}
