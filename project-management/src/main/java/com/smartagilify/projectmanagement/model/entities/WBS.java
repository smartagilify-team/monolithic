package com.smartagilify.projectmanagement.model.entities;

import com.smartagilify.core.entities.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "PM$T_WBS", schema = "PUBLIC")
@NoArgsConstructor
public class WBS extends BaseEntity {

    @JoinColumn(name = "PROJECT_ID", foreignKey = @ForeignKey(name = "WBS_PROJECT_FK_ID"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "SCHEDULED_START_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime scheduledStartDate;

    @Column(name = "SCHEDULED_END_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime scheduledEndDate;

    @Column(name = "ACTUAL_START_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime actualStartDate;

    @Column(name = "ACTUAL_END_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime actualEndDate;

    @Column(name = "WEIGHT_PERCENT")
    private Integer weightPercent;

    @Column(name = "PROGRESS_PERCENT")
    private Integer progressPercent;

}
