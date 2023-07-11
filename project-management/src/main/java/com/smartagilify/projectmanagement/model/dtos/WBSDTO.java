package com.smartagilify.projectmanagement.model.dtos;

import com.smartagilify.core.model.BaseDTO;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class WBSDTO extends BaseDTO {

    private Long projectId;
    private String title;
    private String scheduledStartDate;
    private String scheduledEndDate;
    private String actualStartDate;
    private String actualEndDate;
    private Integer weightPercent;
    private Integer progressPercent;
}
