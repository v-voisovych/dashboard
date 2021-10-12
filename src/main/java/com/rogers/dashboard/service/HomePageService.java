package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rogers.dashboard.model.home_page.HardWareInfo;
import com.rogers.dashboard.model.home_page.MQTTInfo;
import com.rogers.dashboard.model.home_page.ServerInfo;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageService.class);
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
        try {
            HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, qaMonitorPort + MQTT_INFO_URL);
            Type userListType = new TypeToken<MQTTInfo>(){}.getType();
            return new Gson().fromJson(response.body(), userListType);
        } catch (NullPointerException e) {
            MQTTInfo mqttInfo = new MQTTInfo();
            mqttInfo.setErrorMessage("Response is empty or QA Monitor isn't started");
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            return mqttInfo;
        }
    }

	public List<ServerInfo> getServerInfo(String hubName) {
		HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, qaMonitorPort + SERVER_INFO_URL);
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<ServerInfo>>(){}.getType();
		return gson.fromJson(response.body(), userListType);
	}

    public List<HardWareInfo> getHardWareInfo(String hubName) {
        Gson gson = new Gson();
        List<HardWareInfo> list = new ArrayList<>();
        try {
            HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, qaMonitorPort + HARD_WAR_INFO_URL);
            Type userListType = new TypeToken<ArrayList<HardWareInfo>>(){}.getType();
            String responseBody = response.body();
            if (responseBody.startsWith("[")) {
                list = gson.fromJson(responseBody, userListType);
            }
        } catch (NullPointerException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            HardWareInfo hardWareInfo = new HardWareInfo();
            hardWareInfo.setErrorMessage("Response is empty or QA Monitor isn't started");
            list.add(hardWareInfo);
        }
        return list;
    }
}
