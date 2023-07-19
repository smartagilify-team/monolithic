package com.smartagilify.projectmanagement.controllers;

import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.project.ProjectMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectDTO;
import com.smartagilify.projectmanagement.model.entities.Project;
import com.smartagilify.projectmanagement.services.project.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(RestAddress.PROJECT)
public class ProjectController extends BaseController<Project, ProjectMapper, ProjectDTO> {

    private final ProjectService projectService;

    public ProjectController(BaseService<Project, ProjectMapper, ProjectDTO> service, ProjectService projectService) {
        super(service);
        this.projectService = projectService;
    }
}
