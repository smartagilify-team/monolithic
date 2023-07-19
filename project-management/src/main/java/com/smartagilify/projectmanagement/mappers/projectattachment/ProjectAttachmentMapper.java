package com.smartagilify.projectmanagement.mappers.projectattachment;

import com.smartagilify.core.mappers.BaseMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectAttachmentDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectAttachment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProjectAttachmentMapper extends BaseMapper<ProjectAttachment, ProjectAttachmentDTO> {

    @Override
    @Mapping(source = "projectId", target = "project.id")
    ProjectAttachment dto2Entity(ProjectAttachmentDTO arg);

    @Override
    @Mapping(source = "project.id", target = "projectId")
    ProjectAttachmentDTO entity2Dto(ProjectAttachment entity);
}
