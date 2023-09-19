package com.smartagilify.projectmanagement.controllers;

import com.smartagilify.core.controllers.BaseController;

import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.wbs.WBSMapper;
import com.smartagilify.projectmanagement.model.dtos.WBSDTO;
import com.smartagilify.projectmanagement.model.entities.WBS;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestAddress.WBS)
public class WBSController extends BaseController<WBS, WBSMapper, WBSDTO>{

    public WBSController(BaseService<WBS, WBSMapper, WBSDTO> service) {
        super(service);
    }
}
