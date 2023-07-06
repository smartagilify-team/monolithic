package com.smartagilify.baseinfo.controllers;

public class RestAddress {

    private RestAddress() {
    }

    public static final String VERSION = "/v1";
    public static final String BASE_INFO = "/api" + VERSION + "/base-info";
    public static final String BASE_INFO_DETAIL = "/api" + VERSION + "/base-info-detail";
    public static final String FIND_BY_CODE = "/find-by-code/{code}";
    public static final String FIND_ALL_BY_BASE_INFO_ID = "/find-all-by-base-info-id/{baseInfoId}";
    public static final String FIND_ALL_CHILD = "/find-all-child/{baseInfoEntityId}";

}
