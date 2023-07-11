package com.smartagilify.projectmanagement.model.entities;

import com.smartagilify.core.entities.BaseEntity;
import com.smartagilify.projectmanagement.model.enums.ProjectType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PM$T_PROJECT", schema = "PUBLIC")
@NoArgsConstructor
public class Project extends BaseEntity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "START_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;

    @Column(name = "END_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private ProjectType projectType;

    @Column(name = "BUDGET")
    private Double budget;
}
