package com.rogers.dashboard.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HttpRequestSenderService {

	public HttpResponse<String> sendGetRequest(String hubName, String url) {
		HttpResponse<String> response = null;

		HttpClient httpClient = HttpClient.newBuilder()
			.version(HttpClient.Version.HTTP_2)
			.build();

		HttpRequest request = HttpRequest.newBuilder()
			.GET()
			.uri(URI.create(url))
			.header("Content-Type", "application/json")
			.setHeader("Accept", "application/json")
			.build();
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (InterruptedException | IOException exception) {
			exception.printStackTrace();
		}
		return response;
	}
}
