package com.smartagilify.projectmanagement.model.dtos;

import com.smartagilify.core.model.BaseDTO;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAttachmentDTO extends BaseDTO {
    private Long projectId;
    private String attachmentType;
}
