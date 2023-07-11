package com.smartagilify.projectmanagement.services.projectattachment;

import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.projectattachment.ProjectAttachmentMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectAttachmentDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectAttachment;
import com.smartagilify.projectmanagement.repositories.projectattachment.ProjectAttachmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectAttachmentServiceImpl extends
        BaseService<ProjectAttachment, ProjectAttachmentMapper, ProjectAttachmentDTO> implements ProjectAttachmentService{

    private final ProjectAttachmentRepository projectAttachmentRepository;
    public ProjectAttachmentServiceImpl(JpaRepository<ProjectAttachment, Long> jpaRepository,
                                        ProjectAttachmentRepository projectAttachmentRepository) {
        super(jpaRepository);
        this.projectAttachmentRepository = projectAttachmentRepository;
    }

    @Override
    protected Class<ProjectAttachmentMapper> getMapper() {
        return ProjectAttachmentMapper.class;
    }
}
