package com.smartagilify.baseinfo.dtos;

import com.smartagilify.core.model.BaseDTO;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseInfoDetailDTO extends BaseDTO {
    private Long baseInfoId;
    private Long parentId;
    private String title;
    private String code;
    private String color;
    private String icon;
}