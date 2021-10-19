package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.rogers.dashboard.exception.TestServerException;
import com.rogers.dashboard.model.dto.ScenarioDTO;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class TestExecuteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestExecuteService.class);
    private static final String EXECUTE_TEST_CASE_V1_URL = "/autotest/runTest";
    private static final String EXECUTE_TEST_CASE_V2_URL = "/autotest/v2/runTest";
    private static final String EXECUTE_TEST_CASE_QUEUE_V1_URL = "/autotest/runTestQueue";
    private static final String EXECUTE_TEST_CASE_QUEUE_V2_URL = "/autotest/v2/runTestQueue";

    @Value("${qa_monitor.port}")
    private String qaMonitorPort;

    private final HttpRequestSenderService httpRequestSenderService;

    @Autowired
    public TestExecuteService(HttpRequestSenderService httpRequestSenderService) {
        this.httpRequestSenderService = httpRequestSenderService;
    }

    public String executeTestV1(String hubNumber, ScenarioDTO scenarioDTO) throws TestServerException {
        Gson gson = new Gson();
        try {
            HttpResponse<String> response = httpRequestSenderService.sendPostRequest(hubNumber, qaMonitorPort + EXECUTE_TEST_CASE_V1_URL, gson.toJson(scenarioDTO));
            return response.body();
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            return "Response is empty or QA Monitor isn't started";
        }
    }

    public String executeTestV2(String hubNumber, ScenarioDTO scenarioDTO) {
        Gson gson = new Gson();
        try {
            HttpResponse<String> response = httpRequestSenderService.sendPostRequest(hubNumber, qaMonitorPort + EXECUTE_TEST_CASE_V2_URL, gson.toJson(scenarioDTO));
            return response.body();
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            return "Response is empty or QA Monitor isn't started";
        }
    }

    public String executeQueueV1(String hubNumber, List<String> queueList) {
        Gson gson = new Gson();
        try {
            HttpResponse<String> response = httpRequestSenderService.sendPostRequest(hubNumber, qaMonitorPort + EXECUTE_TEST_CASE_QUEUE_V1_URL, gson.toJson(queueList));
            return response.body();
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            return "Response is empty or QA Monitor isn't started";
        }
    }

    public String executeQueueV2(String hubNumber, List<String> queueList) {
        Gson gson = new Gson();
        try {
            HttpResponse<String> response = httpRequestSenderService.sendPostRequest(hubNumber, qaMonitorPort + EXECUTE_TEST_CASE_QUEUE_V2_URL, gson.toJson(queueList));
            return response.body();
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            return "Response is empty or QA Monitor isn't started";
        }
    }
}
