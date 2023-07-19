package com.smartagilify.projectmanagement.model.entities;

import com.smartagilify.core.entities.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PM$T_WBS_PROGRESS_REPORT", schema = "PUBLIC")

@NoArgsConstructor
public class WBSProgressReport extends BaseEntity {

    @JoinColumn(name = "WBS_ID", foreignKey = @ForeignKey(name = "W_PROGRESS_REPORT_WBS_FK_ID"))
    @ManyToOne(fetch = FetchType.EAGER)
    private WBS wbs;

    @JoinColumn(name = "PERFORMANCE_REPORT_ID", foreignKey = @ForeignKey

            (name = "WBS_PROGRESS_REPORT_PERFORMANCE_REPORT_FK_ID"))
    @ManyToOne(fetch = FetchType.EAGER)
    private PerformanceReport performanceReport;

    @Column(name = "PROGRESS_PERCENT")
    private Integer progressPercent;
}
