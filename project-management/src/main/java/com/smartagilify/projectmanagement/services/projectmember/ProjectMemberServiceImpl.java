package com.smartagilify.projectmanagement.services.projectmember;

import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.projectmember.ProjectMemberMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectMemberDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectMember;
import com.smartagilify.projectmanagement.repositories.projectmember.ProjectMemberRepository;
import com.smartagilify.projectmanagement.services.project.ProjectService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberServiceImpl extends BaseService<ProjectMember, ProjectMemberMapper, ProjectMemberDTO>
        implements ProjectService {
    private final ProjectMemberRepository projectMemberRepository;

    public ProjectMemberServiceImpl(JpaRepository<ProjectMember, Long> jpaRepository, ProjectMemberRepository projectMemberRepository) {
        super(jpaRepository);
        this.projectMemberRepository = projectMemberRepository;
    }

    @Override
    protected Class<ProjectMemberMapper> getMapper() {
        return ProjectMemberMapper.class;
    }
}
