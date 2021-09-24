package com.rogers.dashboard.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rogers.dashboard.model.home_page.ServerInfo;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService {

	private final HttpRequestSenderService httpRequestSenderService;

	public HomePageService(HttpRequestSenderService httpRequestSenderService) {
		this.httpRequestSenderService = httpRequestSenderService;
	}

	public List<ServerInfo> getServerInfo(String hubName) {
		HttpResponse<String> response = httpRequestSenderService.sendGetRequest(hubName, "http://localhost:8090/autotest/");
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<ServerInfo>>(){}.getType();
		return gson.fromJson(response.body(), userListType);
	}

}
