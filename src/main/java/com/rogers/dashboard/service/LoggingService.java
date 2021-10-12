package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rogers.dashboard.model.home_page.HardWareInfo;
import com.rogers.dashboard.model.v2.TestNGResult;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoggingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageService.class);
    private final static String VAR = "var";
    private final static String UUID = "uuid";
    private final static String SERVER_INDEX = "serverIndex";
    private final static String TIME_TO = "timeTo";
    private final static String TIME_FROM = "timeFrom";
    private static final String TEST_NG_RESULT_URL = "/autotest/logging/testReport";
    private static final String LAST_DAY_LOGS_URL = "/autotest/logging/lastDayLogs";
    private static final String TIME_RANGE_LOGS_URL = "/autotest/logging/logsInTimeRange";
    private static final String TEST_RESULT_LOGS_URL = "/autotest/logging/logsByTestNGResultUUID";
    private static final String ONLINE_LOGS_URL = "/autotest/logging/onlineLogs";

    @Value("${qa_monitor.port}")
    private String qaMonitorPort;

    private final HttpRequestSenderService httpRequestSenderService;

    @Autowired
    public LoggingService(HttpRequestSenderService httpRequestSenderService) {
        this.httpRequestSenderService = httpRequestSenderService;
    }

    public String logsByUUID(String hubNumber, String uuid) {
        try {
            HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + TEST_RESULT_LOGS_URL, UUID, uuid);
            return response.body();
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            return "Response is empty or QA Monitor isn't started";
        }
    }

    public String lastDayLogs(String hubNumber, String serverIndex) {
        try {
            HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + LAST_DAY_LOGS_URL, SERVER_INDEX, serverIndex);
            return response.body();
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            return "Response is empty or QA Monitor isn't started";
        }
    }

    public String logsInTimeRange(String hubNumber, String serverIndex, String timeFrom, String timeTo) {
        try {
            HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + TIME_RANGE_LOGS_URL, SERVER_INDEX, serverIndex, TIME_FROM, timeFrom, TIME_TO, timeTo);
            return response.body();
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            return "Response is empty or QA Monitor isn't started";
        }
    }

    public List<TestNGResult> getTestNGResult(String hubNumber, String var) {
        Gson gson = new Gson();
        List<TestNGResult> list = new ArrayList<>();
        try {
            HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + TEST_NG_RESULT_URL, VAR, var);
            Type userListType = new TypeToken<List<TestNGResult>>() {
            }.getType();
            String responseBody = response.body();
            if (responseBody.startsWith("[")) {
                list = gson.fromJson(responseBody, userListType);
            }
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            TestNGResult testNGResult = new TestNGResult();
            testNGResult.setErrorMessage("Response is empty or QA Monitor isn't started");
            list.add(testNGResult);
        }
        return list;
    }

    public String getAllLogsWithDeleting(String hubNumber, String serverIndex) {
        try {
            HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + ONLINE_LOGS_URL, SERVER_INDEX, serverIndex);
            return response.body();
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            return "Response is empty or QA Monitor isn't started";
        }
    }
}
