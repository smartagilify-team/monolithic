package com.smartagilify.projectmanagement.mappers.project;

import com.smartagilify.core.mappers.BaseMapper;
import com.smartagilify.projectmanagement.mappers.projectattachment.ProjectAttachmentMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectDTO;
import com.smartagilify.projectmanagement.model.entities.Project;
import org.mapstruct.Mapper;


@Mapper(uses = ProjectAttachmentMapper.class)
public interface ProjectMapper extends BaseMapper<Project, ProjectDTO> {

}
