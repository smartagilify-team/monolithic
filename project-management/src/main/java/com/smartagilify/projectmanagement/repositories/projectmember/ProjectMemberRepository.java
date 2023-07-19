package com.smartagilify.projectmanagement.repositories.projectmember;

import com.smartagilify.projectmanagement.model.entities.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
}
