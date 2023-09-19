package com.smartagilify.projectmanagement.controllers;

import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.projectattachment.ProjectAttachmentMapper;
import com.smartagilify.projectmanagement.model.dtos.ProjectAttachmentDTO;
import com.smartagilify.projectmanagement.model.entities.ProjectAttachment;
import com.smartagilify.projectmanagement.services.projectattachment.ProjectAttachmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestAddress.PROJECT_ATTACHMENT)
public class ProjectAttachmentController extends BaseController<ProjectAttachment, ProjectAttachmentMapper, ProjectAttachmentDTO> {

    private final ProjectAttachmentService projectAttachmentService;

    public ProjectAttachmentController(BaseService<ProjectAttachment, ProjectAttachmentMapper, ProjectAttachmentDTO> service,
                                       ProjectAttachmentService projectAttachmentService) {
        super(service);
        this.projectAttachmentService = projectAttachmentService;
    }
}
