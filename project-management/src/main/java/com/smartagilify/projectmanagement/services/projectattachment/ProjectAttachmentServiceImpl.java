package com.smartagilify.projectmanagement.services.projectattachment;

import com.smartagilify.core.enumerations.EN_STATE;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.exceptions.ApplicationException;
import com.smartagilify.projectmanagement.mappers.projectattachment.ProjectAttachmentMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectAttachmentDTO;
import com.smartagilify.projectmanagement.model.entities.Project;
import com.smartagilify.projectmanagement.model.entities.ProjectAttachment;
import com.smartagilify.projectmanagement.repositories.project.ProjectRepository;
import com.smartagilify.projectmanagement.repositories.projectattachment.ProjectAttachmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProjectAttachmentServiceImpl extends
        BaseService<ProjectAttachment, ProjectAttachmentMapper, ProjectAttachmentDTO> implements ProjectAttachmentService{

    private final ProjectAttachmentRepository projectAttachmentRepository;
    private final ProjectRepository projectRepository;
    public ProjectAttachmentServiceImpl(JpaRepository<ProjectAttachment, Long> jpaRepository,
                                        ProjectAttachmentRepository projectAttachmentRepository, ProjectRepository projectRepository) {
        super(jpaRepository);
        this.projectAttachmentRepository = projectAttachmentRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    protected Class<ProjectAttachmentMapper> getMapper() {
        return ProjectAttachmentMapper.class;
    }

    @Override
    public ProjectAttachmentDTO save(ProjectAttachmentDTO dto, Long userId) {
        ProjectAttachment entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.CREATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(projectAttachmentRepository.save(entity));
    }

    @Override
    public ProjectAttachmentDTO update(ProjectAttachmentDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        ProjectAttachment entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.UPDATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(projectAttachmentRepository.save(entity));
    }

    @Override
    public void softDelete(ProjectAttachmentDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        ProjectAttachment entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.DELETED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        mapper.entity2Dto(projectAttachmentRepository.save(entity));
    }
}
