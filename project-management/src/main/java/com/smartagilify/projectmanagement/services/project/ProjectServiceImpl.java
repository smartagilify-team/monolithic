package com.smartagilify.projectmanagement.services.project;

import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.project.ProjectMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectDTO;
import com.smartagilify.projectmanagement.model.entities.Project;
import com.smartagilify.projectmanagement.repositories.project.ProjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends BaseService<Project, ProjectMapper, ProjectDTO> implements ProjectService{

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(JpaRepository<Project, Long> jpaRepository, ProjectRepository projectRepository) {
        super(jpaRepository);
        this.projectRepository = projectRepository;
    }

    @Override
    protected Class<ProjectMapper> getMapper() {
        return ProjectMapper.class;
    }
}
