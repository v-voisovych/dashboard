package com.rogers.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;

@Service
public class ServerManagementService {

    private static final String START_SERVER_URL = "/autotest/serverManagement/startServer";
    private static final String RESTART_SERVER_URL = "/autotest/serverManagement/reStartServer";
    private static final String STOP_SERVER_URL = "/autotest/serverManagement/stopServer";
    private static final String SERVER_NAME = "serverName";

    @Value("${qa_monitor.port}")
    private String qaMonitorPort;

    HttpRequestSenderService httpRequestSenderService;

    @Autowired
    public ServerManagementService(HttpRequestSenderService httpRequestSenderService) {
        this.httpRequestSenderService = httpRequestSenderService;
    }

    public String startServer(String hubNumber, String serverName) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + START_SERVER_URL, SERVER_NAME, serverName);
        return response.body();
    }

    public String reStartServer(String hubNumber, String serverName) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + RESTART_SERVER_URL, SERVER_NAME, serverName);
        return response.body();
    }

    public String stopServer(String hubNumber, String serverName) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, qaMonitorPort + STOP_SERVER_URL, SERVER_NAME, serverName);
        return response.body();
    }
}
