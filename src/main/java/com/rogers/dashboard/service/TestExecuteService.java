package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rogers.dashboard.exception.TestServerException;
import com.rogers.dashboard.model.dto.ScenarioDTO;
import com.rogers.dashboard.model.v1.TestResult;
import com.rogers.dashboard.model.v2.TestNGResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.http.HttpResponse;

@Service
public class TestExecuteService {
    private static final String EXECUTE_TEST_CASE_V1_URL = "8091/autotest/runTest";
    private static final String EXECUTE_TEST_CASE_V2_URL = "8091/autotest/v2/runTest";

    private final HttpRequestSenderService httpRequestSenderService;

    @Autowired
    public TestExecuteService(HttpRequestSenderService httpRequestSenderService) {
        this.httpRequestSenderService = httpRequestSenderService;
    }

    public TestResult executeTestV1(String hubNumber, ScenarioDTO scenarioDTO) throws TestServerException {
        Gson gson = new Gson();
        HttpResponse<String> response = httpRequestSenderService.sendPostRequest(hubNumber, EXECUTE_TEST_CASE_V1_URL, gson.toJson(scenarioDTO));
        Type userListType = new TypeToken<TestResult>(){}.getType();
        return gson.fromJson(response.body(), userListType);
    }

    public TestNGResult executeTestV2(String hubNumber, ScenarioDTO scenarioDTO) {
        Gson gson = new Gson();
        HttpResponse<String> response = httpRequestSenderService.sendPostRequest(hubNumber, EXECUTE_TEST_CASE_V2_URL, gson.toJson(scenarioDTO));
        Type userListType = new TypeToken<TestNGResult>(){}.getType();
        return gson.fromJson(response.body(), userListType);
    }
}
