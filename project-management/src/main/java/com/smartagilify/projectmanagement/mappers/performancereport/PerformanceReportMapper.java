package com.smartagilify.projectmanagement.mappers.performancereport;
import com.smartagilify.core.mappers.BaseMapper;
import com.smartagilify.projectmanagement.model.dtos.PerformanceReportDTO;
import com.smartagilify.projectmanagement.model.entities.PerformanceReport;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PerformanceReportMapper extends BaseMapper<PerformanceReport, PerformanceReportDTO> {

    @Override
    @Mapping(source = "projectId", target = "project.id")
    PerformanceReport dto2Entity(PerformanceReportDTO arg);

    @Override
    @InheritInverseConfiguration
    @Mapping(source = "project.id", target = "projectId")
    PerformanceReportDTO entity2Dto(PerformanceReport entity);
}
