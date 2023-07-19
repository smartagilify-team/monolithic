package com.smartagilify.projectmanagement.controllers;

import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.projectmember.ProjectMemberMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectMemberDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectMember;
import com.smartagilify.projectmanagement.services.projectmember.ProjectMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(RestAddress.PROJECT_MEMBER)
public class ProjectMemberController extends BaseController<ProjectMember, ProjectMemberMapper, ProjectMemberDTO> {

    private final ProjectMemberService projectMemberService;

    public ProjectMemberController(BaseService<ProjectMember, ProjectMemberMapper, ProjectMemberDTO> service, ProjectMemberService projectMemberService) {
        super(service);
        this.projectMemberService = projectMemberService;
    }
}
