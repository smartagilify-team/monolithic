package com.smartagilify.projectmanagement.controllers;

public class RestAddress {

    private RestAddress() {
    }

    public static final String VERSION = "/v1";
    public static final String API = "/api";
    public static final String PROJECT = API + VERSION + "/project";
    public static final String PROJECT_MEMBER = API + VERSION + "/project-member";
    public static final String PROJECT_ATTACHMENT = API + VERSION + "/project-attachment";
    public static final String PROJECT_SETTING = API + VERSION + "/project-setting";

    public static final String WBS = API + VERSION + "/wbs";
    public static final String WBS_PROGRESS_REPORT = API + VERSION + "/wbs-progress-report";
    public static final String PERFORMANCE_REPORT = API + VERSION + "/performance-report";



}
