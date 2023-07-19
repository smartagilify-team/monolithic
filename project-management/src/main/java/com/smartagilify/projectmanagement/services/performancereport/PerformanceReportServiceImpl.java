package com.smartagilify.projectmanagement.services.performancereport;

import com.smartagilify.core.enumerations.EN_STATE;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.exceptions.ApplicationException;
import com.smartagilify.projectmanagement.mappers.performancereport.PerformanceReportMapper;
import com.smartagilify.projectmanagement.model.dtos.PerformanceReportDTO;
import com.smartagilify.projectmanagement.model.entities.PerformanceReport;
import com.smartagilify.projectmanagement.model.entities.Project;
import com.smartagilify.projectmanagement.repositories.performancereport.PerformanceReportRepository;
import com.smartagilify.projectmanagement.repositories.project.ProjectRepository;
import com.smartagilify.projectmanagement.services.project.ProjectService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PerformanceReportServiceImpl extends
        BaseService<PerformanceReport, PerformanceReportMapper, PerformanceReportDTO> implements PerformanceReportService {

    private final PerformanceReportRepository performanceReportRepository;
    private final ProjectRepository projectRepository;

    public PerformanceReportServiceImpl(JpaRepository<PerformanceReport, Long> jpaRepository,
                                        PerformanceReportRepository performanceReportRepository,
                                        ProjectRepository projectRepository) {
        super(jpaRepository);
        this.performanceReportRepository = performanceReportRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    protected Class<PerformanceReportMapper> getMapper() {
        return PerformanceReportMapper.class;
    }

    @Override
    public PerformanceReportDTO save(PerformanceReportDTO dto, Long userId) {
        PerformanceReport entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.CREATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(performanceReportRepository.save(entity));
    }

    @Override
    public PerformanceReportDTO update(PerformanceReportDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        PerformanceReport entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.UPDATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(performanceReportRepository.save(entity));
    }

    @Override
    public void softDelete(PerformanceReportDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        PerformanceReport entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.DELETED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        performanceReportRepository.save(entity);
    }
}
