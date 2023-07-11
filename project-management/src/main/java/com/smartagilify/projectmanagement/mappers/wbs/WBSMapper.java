package com.smartagilify.projectmanagement.mappers.wbs;

import com.smartagilify.core.mappers.BaseMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectAttachmentDTO;
import com.smartagilify.projectmanagement.model.dtos.WBSDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectAttachment;
import com.smartagilify.projectmanagement.model.entities.WBS;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WBSMapper extends BaseMapper<WBS, WBSDTO> {

    @Override
    @Mapping(source = "projectId", target = "project.id")
    WBS dto2Entity(WBSDTO arg);

    @Override
    @InheritInverseConfiguration
    @Mapping(source = "project.id", target = "projectId")
    WBSDTO entity2Dto(WBS entity);
}
