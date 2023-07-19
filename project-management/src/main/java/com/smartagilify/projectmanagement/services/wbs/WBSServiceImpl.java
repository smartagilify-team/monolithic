package com.smartagilify.projectmanagement.services.wbs;

import com.smartagilify.core.enumerations.EN_STATE;
import com.smartagilify.core.model.InputDTO;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.exceptions.ApplicationException;
import com.smartagilify.projectmanagement.mappers.wbs.WBSMapper;
import com.smartagilify.projectmanagement.model.dtos.WBSDTO;
import com.smartagilify.projectmanagement.model.dtos.WBSDTO;
import com.smartagilify.projectmanagement.model.entities.Project;
import com.smartagilify.projectmanagement.model.entities.ProjectMember;
import com.smartagilify.projectmanagement.model.entities.WBS;
import com.smartagilify.projectmanagement.repositories.project.ProjectRepository;
import com.smartagilify.projectmanagement.repositories.wbs.WBSRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WBSServiceImpl extends BaseService<WBS, WBSMapper, WBSDTO> implements WBSService{

    private final WBSRepository wbsRepository;
    private final ProjectRepository projectRepository; 
    
    public WBSServiceImpl(JpaRepository<WBS, Long> jpaRepository, 
                          WBSRepository wbsRepository, 
                          ProjectRepository projectRepository) {
        super(jpaRepository);
        this.wbsRepository = wbsRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    protected Class<WBSMapper> getMapper() {
        return WBSMapper.class;
    }

    @Override
    public WBSDTO save(WBSDTO dto, Long userId) {
        WBS entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.CREATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(wbsRepository.save(entity));
    }

    @Override
    public WBSDTO update(WBSDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        WBS entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.UPDATED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        return mapper.entity2Dto(wbsRepository.save(entity));
    }

    @Override
    public void softDelete(WBSDTO dto, Long userId) {
        if(dto.getId() == null) throw new ApplicationException("This entity is not yet saved");
        WBS entity = mapper.dto2Entity(dto);
        Project project = projectRepository.getReferenceById(dto.getProjectId());
        entity.setProject(project); entity.setState(EN_STATE.DELETED);
        entity.setCreateById(userId); entity.setCreateDate(LocalDateTime.now());
        mapper.entity2Dto(wbsRepository.save(entity));
    }
}
