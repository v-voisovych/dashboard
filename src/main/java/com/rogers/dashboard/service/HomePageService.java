package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rogers.dashboard.model.home_page.MQTTInfo;
import com.rogers.dashboard.model.home_page.ServerInfo;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService {

    private static final String MQTT_INFO_URL = "8091/autotest/homePage/getMQTTInfo";
    private static final String SERVER_INFO_URL = "8091/autotest/homePage/getServerInfo";

    private final HttpRequestSenderService httpRequestSenderService;

    public HomePageService(HttpRequestSenderService httpRequestSenderService) {
        this.httpRequestSenderService = httpRequestSenderService;
    }

    public MQTTInfo getMQTTInfo(String hubName) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, MQTT_INFO_URL);
        return new Gson().fromJson(response.body(), MQTTInfo.class);
    }

	public List<ServerInfo> getServerInfo(String hubName) {
		HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, SERVER_INFO_URL);
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<ServerInfo>>(){}.getType();
		return gson.fromJson(response.body(), userListType);
	}

}
