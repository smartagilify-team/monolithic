package com.smartagilify.projectmanagement.mappers.projectsetting;

import com.smartagilify.core.mappers.BaseMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectSettingDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectSetting;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectSettingMapper extends BaseMapper<ProjectSetting, ProjectSettingDTO> {

    @Override
    @Mapping(source = "projectId", target = "project.id")
    ProjectSetting dto2Entity(ProjectSettingDTO arg);

    @Override
    @InheritInverseConfiguration
    @Mapping(source = "project.id", target = "projectId")
    ProjectSettingDTO entity2Dto(ProjectSetting entity);
}
