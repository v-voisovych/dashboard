package com.rogers.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;

@Service
public class ServerManagementService {

    private static final String START_SERVER_URL = "8091/autotest/serverManagement/startServer";
    private static final String RESTART_SERVER_URL = "8091/autotest/serverManagement/reStartServer";
    private static final String STOP_SERVER_URL = "8091/autotest/serverManagement/stopServer";
    private static final String SERVER_NAME = "serverName";

    HttpRequestSenderService httpRequestSenderService;

    @Autowired
    public ServerManagementService(HttpRequestSenderService httpRequestSenderService) {
        this.httpRequestSenderService = httpRequestSenderService;
    }

    public String startServer(String hubNumber, String serverName) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, START_SERVER_URL, SERVER_NAME, serverName);
        return response.body();
    }

    public String reStartServer(String hubNumber, String serverName) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, RESTART_SERVER_URL, SERVER_NAME, serverName);
        return response.body();
    }

    public String stopServer(String hubNumber, String serverName) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubNumber, STOP_SERVER_URL, SERVER_NAME, serverName);
        return response.body();
    }
}
