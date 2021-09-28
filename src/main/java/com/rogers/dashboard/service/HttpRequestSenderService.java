package com.rogers.dashboard.service;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class HttpRequestSenderService {

    private static final String HTTP = "http://";

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

    public HttpResponse<String> sendGetRequest(String hubName, String url) {
        HttpResponse<String> response = null;

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(HTTP + getHubIP(hubName) + ":" + url))
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

    public HttpResponse<String> sendGetRequest(String hubName, String url, String... parameters) {
        HttpResponse<String> response = null;
        List nameValuePairs = new ArrayList<>();
        for (int i = 0; i < parameters.length; i++) {
            nameValuePairs.add(new BasicNameValuePair(parameters[i], parameters[++i]));
        }
        URI uri = null;
        try {
            uri = new URIBuilder(HTTP + getHubIP(hubName) + ":" + url)
                    .addParameters(nameValuePairs)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
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

    public HttpResponse<String> sendPostRequest(String hubName, String url, String body) {
        HttpResponse<String> response = null;

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(HTTP + getHubIP(hubName) + ":" + url))
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
