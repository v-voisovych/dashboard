package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rogers.dashboard.model.home_page.SystemUsage;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class SystemUsageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemUsageService.class);
    private final String SYSTEM_USAGE_URL = "/autotest/systemUsage/getSystemUsage";

    @Value("${qa_monitor.port}")
    private String qaMonitorPort;

    private final HttpRequestSenderService httpRequestSenderService;

    @Autowired
    public SystemUsageService(HttpRequestSenderService httpRequestSenderService) {
        this.httpRequestSenderService = httpRequestSenderService;
    }

    public SystemUsage getSystemUsage(String hubName) {
        String body;
        try {
            body = httpRequestSenderService.sendGetRequest(hubName, qaMonitorPort + SYSTEM_USAGE_URL).body();
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            SystemUsage systemUsage = new SystemUsage();
            systemUsage.setErrorMessage("Response is empty or QA Monitor isn't started");
            return systemUsage;
        }
        Type userListType = new TypeToken<SystemUsage>() {
        }.getType();
        return new Gson().fromJson(body, userListType);
    }
}
