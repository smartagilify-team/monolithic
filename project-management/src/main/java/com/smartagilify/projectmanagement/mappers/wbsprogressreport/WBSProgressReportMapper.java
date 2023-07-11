package com.smartagilify.projectmanagement.mappers.wbsprogressreport;

import com.smartagilify.core.mappers.BaseMapper;
import com.smartagilify.projectmanagement.model.dtos.WBSDTO;
import com.smartagilify.projectmanagement.model.dtos.WBSProgressReportDTO;
import com.smartagilify.projectmanagement.model.entities.WBS;
import com.smartagilify.projectmanagement.model.entities.WBSProgressReport;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WBSProgressReportMapper extends BaseMapper<WBSProgressReport, WBSProgressReportDTO> {

    @Override
    @Mapping(source = "wbsId", target = "wbs.id")
    @Mapping(source = "performanceReportId", target = "performanceReport.id")
    WBSProgressReport dto2Entity(WBSProgressReportDTO arg);

    @Override
    @InheritInverseConfiguration
    @Mapping(source = "wbs.id", target = "wbsId")
    @Mapping(source = "performanceReport.id", target = "performanceReportId")
    WBSProgressReportDTO entity2Dto(WBSProgressReport entity);
}

