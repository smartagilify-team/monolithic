package com.smartagilify.projectmanagement.services.projectsetting;

import com.smartagilify.core.enumerations.EN_STATE;
import com.smartagilify.core.model.InputDTO;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.exceptions.ApplicationException;
import com.smartagilify.projectmanagement.mappers.projectsetting.ProjectSettingMapper;
import com.smartagilify.projectmanagement.model.dtos.PerformanceReportDTO;
import com.smartagilify.projectmanagement.model.dtos.ProjectSettingDTO;
import com.smartagilify.projectmanagement.model.entities.Project;
import com.smartagilify.projectmanagement.model.entities.ProjectSetting;
import com.smartagilify.projectmanagement.repositories.project.ProjectRepository;
import com.smartagilify.projectmanagement.repositories.projectsetting.ProjectSettingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProjectSettingServiceImpl extends BaseService<ProjectSetting, ProjectSettingMapper, ProjectSettingDTO>
        implements ProjectSettingService{

    private final ProjectSettingRepository projectSettingRepository;
    private final ProjectRepository projectRepository;

    public ProjectSettingServiceImpl(JpaRepository<ProjectSetting, Long> jpaRepository,
                                     ProjectSettingRepository projectSettingRepository, ProjectRepository projectRepository) {
        super(jpaRepository);
        this.projectSettingRepository = projectSettingRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    protected Class<ProjectSettingMapper> getMapper() {
        return ProjectSettingMapper.class;
    }

    @Override
    public ProjectSettingDTO save(ProjectSettingDTO dto, Long userId) {
        ProjectSetting entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.CREATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(projectSettingRepository.save(entity));
    }

    @Override
    public ProjectSettingDTO update(ProjectSettingDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        ProjectSetting entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.UPDATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(projectSettingRepository.save(entity));
    }

    @Override
    public void softDelete(ProjectSettingDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        ProjectSetting entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.DELETED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        mapper.entity2Dto(projectSettingRepository.save(entity));
    }
}
