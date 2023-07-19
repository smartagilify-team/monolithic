package com.smartagilify.projectmanagement.controllers;

import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.projectsetting.ProjectSettingMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectSettingDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectSetting;
import com.smartagilify.projectmanagement.services.projectsetting.ProjectSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(RestAddress.PROJECT_SETTING)
public class ProjectSettingController extends BaseController<ProjectSetting, ProjectSettingMapper, ProjectSettingDTO> {

    private final ProjectSettingService projectSettingService;

    public ProjectSettingController(BaseService<ProjectSetting, ProjectSettingMapper, ProjectSettingDTO> service,
                                    ProjectSettingService projectSettingService) {
        super(service);
        this.projectSettingService = projectSettingService;
    }

}
