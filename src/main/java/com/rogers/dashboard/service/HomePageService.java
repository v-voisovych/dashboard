package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rogers.dashboard.model.home_page.HardWareInfo;
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
    private static final String HARD_WAR_INFO_URL = "8091/autotest/homePage/getHardWareInfo";

    private final HttpRequestSenderService httpRequestSenderService;

    public HomePageService(HttpRequestSenderService httpRequestSenderService) {
        this.httpRequestSenderService = httpRequestSenderService;
    }

    public MQTTInfo getMQTTInfo(String hubName) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, MQTT_INFO_URL);
        Type userListType = new TypeToken<MQTTInfo>(){}.getType();
        return new Gson().fromJson(response.body(), userListType);
    }

	public List<ServerInfo> getServerInfo(String hubName) {
		HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, SERVER_INFO_URL);
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<ServerInfo>>(){}.getType();
		return gson.fromJson(response.body(), userListType);
	}

    public List<HardWareInfo> getHardWareInfo(String hubName) {
        HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, HARD_WAR_INFO_URL);
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<ServerInfo>>(){}.getType();
        return gson.fromJson(response.body(), userListType);
    }

}
