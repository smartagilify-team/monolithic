package com.smartagilify.projectmanagement.model.entities;

import com.smartagilify.core.entities.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "PM$T_PROJECT_MEMBER", schema = "PUBLIC")
@NoArgsConstructor
public class ProjectMember extends BaseEntity {

    @JoinColumn(name = "PROJECT_ID", foreignKey = @ForeignKey(name = "P_MEMBER_PROJECT_FK_ID"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    //TODO: add user and role after the security module is created

    @Column(name = "START_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;

    @Column(name = "END_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;
}
