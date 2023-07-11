package com.smartagilify.projectmanagement.services.projectsetting;

import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.projectsetting.ProjectSettingMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectSettingDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectSetting;
import com.smartagilify.projectmanagement.repositories.projectsetting.ProjectSettingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectSettingServiceImpl extends BaseService<ProjectSetting, ProjectSettingMapper, ProjectSettingDTO>
        implements ProjectSettingService{

    private final ProjectSettingRepository projectSettingRepository;
    public ProjectSettingServiceImpl(JpaRepository<ProjectSetting, Long> jpaRepository,
                                     ProjectSettingRepository projectSettingRepository) {
        super(jpaRepository);
        this.projectSettingRepository = projectSettingRepository;
    }

    @Override
    protected Class<ProjectSettingMapper> getMapper() {
        return ProjectSettingMapper.class;
    }
}
