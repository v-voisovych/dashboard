package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rogers.dashboard.exception.TestServerException;
import com.rogers.dashboard.model.dto.ScenarioDTO;
import com.rogers.dashboard.model.v1.TestResult;
import com.rogers.dashboard.model.v2.TestNGResult;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.http.HttpResponse;

@Service
public class TestExecuteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageService.class);
    private static final String EXECUTE_TEST_CASE_V1_URL = "/autotest/runTest";
    private static final String EXECUTE_TEST_CASE_V2_URL = "/autotest/v2/runTest";

    @Value("${qa_monitor.port}")
    private String qaMonitorPort;

    private final HttpRequestSenderService httpRequestSenderService;

    @Autowired
    public TestExecuteService(HttpRequestSenderService httpRequestSenderService) {
        this.httpRequestSenderService = httpRequestSenderService;
    }

    public TestResult executeTestV1(String hubNumber, ScenarioDTO scenarioDTO) throws TestServerException {
        Gson gson = new Gson();
        try {
            HttpResponse<String> response = httpRequestSenderService.sendPostRequest(hubNumber, qaMonitorPort + EXECUTE_TEST_CASE_V1_URL, gson.toJson(scenarioDTO));
            Type userListType = new TypeToken<TestResult>() {
            }.getType();
            return gson.fromJson(response.body(), userListType);
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            TestResult testResult = new TestResult();
            testResult.setErrorMessage("Response is empty or QA Monitor isn't started");
            return testResult;
        }
    }

    public TestNGResult executeTestV2(String hubNumber, ScenarioDTO scenarioDTO) {
        Gson gson = new Gson();
        try {
            HttpResponse<String> response = httpRequestSenderService.sendPostRequest(hubNumber, qaMonitorPort + EXECUTE_TEST_CASE_V2_URL, gson.toJson(scenarioDTO));
            Type userListType = new TypeToken<TestNGResult>(){}.getType();
            return gson.fromJson(response.body(), userListType);
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            TestNGResult testNGResult = new TestNGResult();
            testNGResult.setErrorMessage("Response is empty or QA Monitor isn't started");
            return testNGResult;
        }
    }
}
