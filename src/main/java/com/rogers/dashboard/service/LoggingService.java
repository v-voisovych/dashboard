package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rogers.dashboard.model.v2.TestNGResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class LoggingService {

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
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + TEST_RESULT_LOGS_URL, UUID, uuid);
        return response.body();
    }

    public String lastDayLogs(String hubNumber, String serverIndex) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + LAST_DAY_LOGS_URL, SERVER_INDEX, serverIndex);
        return response.body();
    }

    public String logsInTimeRange(String hubNumber, String serverIndex, String timeFrom, String timeTo) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + TIME_RANGE_LOGS_URL, SERVER_INDEX, serverIndex, TIME_FROM, timeFrom, TIME_TO, timeTo);
        return response.body();
    }

    public List<TestNGResult> getTestNGResult(String hubNumber, String var) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + TEST_NG_RESULT_URL, VAR, var);
        Type userListType = new TypeToken<List<TestNGResult>>(){}.getType();
        return new Gson().fromJson(response.body(), userListType);
    }

    public String getAllLogsWithDeleting(String hubNumber, String serverIndex) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + ONLINE_LOGS_URL, SERVER_INDEX, serverIndex);
        return response.body();
    }
}
