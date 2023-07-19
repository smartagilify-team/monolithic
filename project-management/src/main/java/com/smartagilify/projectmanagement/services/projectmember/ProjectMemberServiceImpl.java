package com.smartagilify.projectmanagement.services.projectmember;

import com.smartagilify.core.enumerations.EN_STATE;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.exceptions.ApplicationException;
import com.smartagilify.projectmanagement.mappers.projectmember.ProjectMemberMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectMemberDTO;
import com.smartagilify.projectmanagement.model.entities.Project;
import com.smartagilify.projectmanagement.model.entities.ProjectMember;
import com.smartagilify.projectmanagement.repositories.project.ProjectRepository;
import com.smartagilify.projectmanagement.repositories.projectmember.ProjectMemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProjectMemberServiceImpl extends BaseService<ProjectMember, ProjectMemberMapper, ProjectMemberDTO>
        implements ProjectMemberService {
    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;

    public ProjectMemberServiceImpl(JpaRepository<ProjectMember, Long> jpaRepository, ProjectMemberRepository projectMemberRepository, ProjectRepository projectRepository) {
        super(jpaRepository);
        this.projectMemberRepository = projectMemberRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    protected Class<ProjectMemberMapper> getMapper() {
        return ProjectMemberMapper.class;
    }

    @Override
    public ProjectMemberDTO save(ProjectMemberDTO dto, Long userId) {
        ProjectMember entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.CREATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(projectMemberRepository.save(entity));
    }

    @Override
    public ProjectMemberDTO update(ProjectMemberDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        ProjectMember entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.UPDATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(projectMemberRepository.save(entity));
    }

    @Override
    public void softDelete(ProjectMemberDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        ProjectMember entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.DELETED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        mapper.entity2Dto(projectMemberRepository.save(entity));
    }
}
