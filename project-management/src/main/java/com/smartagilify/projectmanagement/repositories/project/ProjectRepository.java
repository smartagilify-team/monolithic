package com.smartagilify.projectmanagement.repositories.project;

import com.smartagilify.projectmanagement.model.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
