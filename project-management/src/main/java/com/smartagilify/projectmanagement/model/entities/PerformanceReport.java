package com.smartagilify.projectmanagement.model.entities;

import com.smartagilify.core.entities.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PM$T_PERFORMANCE_REPORT", schema = "PUBLIC")
@NoArgsConstructor
public class PerformanceReport extends BaseEntity {

    @JoinColumn(name = "PROJECT_ID", foreignKey = @ForeignKey(name = "PERFORMANCE_REPORT_PROJECT_FK_ID"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    @Column(name = "REPORT", columnDefinition = "TEXT")
    private String report;
}
