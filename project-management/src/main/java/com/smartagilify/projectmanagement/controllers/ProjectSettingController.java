package com.smartagilify.projectmanagement.controllers;

import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.projectsetting.ProjectSettingMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectSettingDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectSetting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestAddress.PROJECT_SETTING)
public class ProjectSettingController extends BaseController<ProjectSetting, ProjectSettingMapper, ProjectSettingDTO> {

    public ProjectSettingController(BaseService<ProjectSetting, ProjectSettingMapper, ProjectSettingDTO> service) {
        super(service);
    }

}
