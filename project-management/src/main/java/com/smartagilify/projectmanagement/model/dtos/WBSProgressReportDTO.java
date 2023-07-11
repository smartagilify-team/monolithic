package com.smartagilify.projectmanagement.model.dtos;

import com.smartagilify.core.model.BaseDTO;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class WBSProgressReportDTO extends BaseDTO {
    private Long wbsId;
    private Long performanceReportId;
    private Integer progressPercent;

}
