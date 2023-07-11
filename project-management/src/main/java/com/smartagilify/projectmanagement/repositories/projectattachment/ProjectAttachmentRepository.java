package com.smartagilify.projectmanagement.repositories.projectattachment;

import com.smartagilify.projectmanagement.model.entities.ProjectAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectAttachmentRepository extends JpaRepository<ProjectAttachment, Long> {
}
