package com.smartagilify.projectmanagement.model.dtos;

import com.smartagilify.core.model.BaseDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectAttachment;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO extends BaseDTO {

    private String title;
    private String startDate;
    private String endDate;
    private String projectType;
    private Double budget;
    private List<ProjectAttachmentDTO> attachments;
}
