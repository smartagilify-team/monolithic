package com.smartagilify.projectmanagement.controllers;

import com.smartagilify.core.controllers.BaseController;

import com.smartagilify.core.services.BaseService;
import com.smartagilify.projectmanagement.mappers.wbs.WBSMapper;
import com.smartagilify.projectmanagement.model.dtos.WBSDTO;
import com.smartagilify.projectmanagement.model.entities.WBS;
import com.smartagilify.projectmanagement.services.wbs.WBSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Slf4j
@RestController
@RequestMapping(RestAddress.WBS)
public class WBSController extends BaseController<WBS, WBSMapper, WBSDTO>{

    private final WBSService wbsService;

    public WBSController(BaseService<WBS, WBSMapper, WBSDTO> service, WBSService wbsService) {
        super(service);
        this.wbsService = wbsService;
    }
}
