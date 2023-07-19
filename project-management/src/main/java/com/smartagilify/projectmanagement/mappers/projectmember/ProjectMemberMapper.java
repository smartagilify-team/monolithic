package com.smartagilify.projectmanagement.mappers.projectmember;

import com.smartagilify.core.mappers.BaseMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectMemberDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectMember;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper extends BaseMapper<ProjectMember, ProjectMemberDTO> {

    @Override
    @Mapping(source = "projectId", target = "project.id")
    ProjectMember dto2Entity(ProjectMemberDTO arg);

    @Override
    @InheritInverseConfiguration
    @Mapping(source = "project.id", target = "projectId")
    ProjectMemberDTO entity2Dto(ProjectMember entity);


}
