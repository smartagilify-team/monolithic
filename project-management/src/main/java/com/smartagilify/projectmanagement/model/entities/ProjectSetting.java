package com.smartagilify.projectmanagement.model.entities;


import com.smartagilify.core.entities.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PM$T_PROJECT_SETTING", schema = "PUBLIC")
@NoArgsConstructor
public class ProjectSetting extends BaseEntity {

    @JoinColumn(name = "PROJECT_ID", foreignKey = @ForeignKey(name = "P_SETTING_PROJECT_FK_ID"))
    @OneToOne(fetch = FetchType.EAGER)
    private Project project;

    @Column(name = "PERFORMANCE_REPORT_PERIOD")
    private Integer performanceReportPeriod;
}
