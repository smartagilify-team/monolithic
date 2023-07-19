package com.smartagilify.projectmanagement.repositories.projectsetting;

import com.smartagilify.projectmanagement.model.entities.ProjectSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectSettingRepository extends JpaRepository<ProjectSetting, Long> {
}
