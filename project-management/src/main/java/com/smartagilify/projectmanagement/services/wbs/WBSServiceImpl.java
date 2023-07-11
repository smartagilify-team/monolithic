package com.smartagilify.projectmanagement.services.wbs;

import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.wbs.WBSMapper;
import com.smartagilify.projectmanagement.model.dtos.WBSDTO;
import com.smartagilify.projectmanagement.model.entities.WBS;
import com.smartagilify.projectmanagement.repositories.wbs.WBSRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class WBSServiceImpl extends BaseService<WBS, WBSMapper, WBSDTO> implements WBSService{

    private final WBSRepository wbsRepository;
    public WBSServiceImpl(JpaRepository<WBS, Long> jpaRepository, WBSRepository wbsRepository) {
        super(jpaRepository);
        this.wbsRepository = wbsRepository;
    }

    @Override
    protected Class<WBSMapper> getMapper() {
        return WBSMapper.class;
    }
}
