package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rogers.dashboard.model.home_page.HardWareInfo;
import com.rogers.dashboard.model.home_page.MQTTInfo;
import com.rogers.dashboard.model.home_page.ServerInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService {

    private static final String MQTT_INFO_URL = "/autotest/homePage/getMQTTInfo";
    private static final String SERVER_INFO_URL = "/autotest/homePage/getServerInfo";
    private static final String HARD_WAR_INFO_URL = "/autotest/homePage/getHardWareInfo";

    @Value("${qa_monitor.port}")
    private String qaMonitorPort;

    private final HttpRequestSenderService httpRequestSenderService;

    public HomePageService(HttpRequestSenderService httpRequestSenderService) {
        this.httpRequestSenderService = httpRequestSenderService;
    }

    public MQTTInfo getMQTTInfo(String hubName) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, qaMonitorPort + MQTT_INFO_URL);
        Type userListType = new TypeToken<MQTTInfo>(){}.getType();
        return new Gson().fromJson(response.body(), userListType);
    }

	public List<ServerInfo> getServerInfo(String hubName) {
		HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, qaMonitorPort + SERVER_INFO_URL);
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<ServerInfo>>(){}.getType();
		return gson.fromJson(response.body(), userListType);
	}

    public List<HardWareInfo> getHardWareInfo(String hubName) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, qaMonitorPort + HARD_WAR_INFO_URL);
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<HardWareInfo>>(){}.getType();
        return gson.fromJson(response.body(), userListType);
    }

}
