package com.smartagilify.projectmanagement.model.entities;

import com.smartagilify.core.entities.BaseEntity;
import com.smartagilify.projectmanagement.model.enums.AttachmentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PM$T_PROJECT_ATTACHMENT", schema = "PUBLIC")
@NoArgsConstructor
public class ProjectAttachment extends BaseEntity{

    @JoinColumn(name = "PROJECT_ID", foreignKey = @ForeignKey(name = "P_ATTACHMENT_PROJECT_FK_ID"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    @Enumerated(EnumType.STRING)
    private AttachmentType attachmentType;
}
