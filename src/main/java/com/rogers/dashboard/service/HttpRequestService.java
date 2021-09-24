package com.rogers.dashboard.service;

import com.rogers.dashboard.exception.HttpRequestException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HttpRequestService {

    public String sendRequest(String urlRequest, String requestMethod) throws HttpRequestException {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlRequest);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(6000);
            connection.setReadTimeout(6000);
            int codeResponse = connection.getResponseCode();
            if (codeResponse != 200) {
                content.append(codeResponse).append("\n");
                BufferedReader error = new BufferedReader(
                        new InputStreamReader(connection.getErrorStream()));
                String inputLine;
                while ((inputLine = error.readLine()) != null) {
                    content.append(inputLine).append("\n");
                }
                error.close();
                throw new HttpRequestException(content.toString());
            } else {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                connection.disconnect();
            }
        } catch (IOException e) {
            throw new HttpRequestException(ExceptionUtils.getStackTrace(e).split("\n")[0]);
        }
        return content.toString();
    }
}
