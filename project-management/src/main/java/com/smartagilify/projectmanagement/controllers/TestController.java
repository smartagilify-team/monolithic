package com.smartagilify.projectmanagement.controllers;

import com.smartagilify.baseinfo.entities.BaseInfo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    public void test() {
        BaseInfo bi = new BaseInfo();//FIXME remove it
    }
}
