package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.rogers.dashboard.exception.HttpRequestException;
import com.rogers.dashboard.model.home_page.MQTTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HomePageService {

    private static final String GET_REQUEST = "GET";
    private static final String MQTT_INFO_URL = "/autotest/homePage/getMQTTInfo";
    private static final String HTTP = "http://";
    private static final String QA_MONITOR_PORT = ":8091";

    @Value("${hub.one.ip}")
    private String hubOneIP;
    @Value("${hub.two.ip}")
    private String hubTwoIP;
    @Value("${hub.three.ip}")
    private String hubThreeIP;
    @Value("${hub.four.ip}")
    private String hubFourIP;
    @Value("${hub.five.ip}")
    private String hubFiveIP;
    @Value("${hub.six.ip}")
    private String hubSixIP;
    @Value("${local.host}")
    private String localHost;

    private HttpRequestService httpRequestService;

    @Autowired
    public HomePageService(HttpRequestService httpRequestService) {
        this.httpRequestService = httpRequestService;
    }

    public MQTTInfo getMQTTInfo(String hubName) throws HttpRequestException {
        String url = HTTP + getHubIP(hubName) + QA_MONITOR_PORT + MQTT_INFO_URL;
        String mqttInfoString = httpRequestService.sendRequest(url, GET_REQUEST);
        return new Gson().fromJson(mqttInfoString, MQTTInfo.class);
    }

    private String getHubIP(String hubName) {
        switch (hubName) {
            case "hub1":
                return hubOneIP;
            case "hub2":
                return hubTwoIP;
            case "hub3":
                return hubThreeIP;
            case "hub4":
                return hubFourIP;
            case "hub5":
                return hubFiveIP;
            case "hub6":
                return hubSixIP;
            default:
                return localHost;
        }
    }
}
