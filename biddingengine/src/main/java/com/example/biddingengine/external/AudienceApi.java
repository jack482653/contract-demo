package com.example.biddingengine.external;

import com.example.biddingengine.model.Audience;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AudienceApi {

    @Value("${dmp.host}")
    private String dmpUrl;

    private Gson gson = new Gson();

    public Audience getAudience(String audienceId) throws IOException, InterruptedException {
        HttpClient client = HttpClient
                .newBuilder()
                .build();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(String.format("%s/audiences/%s", dmpUrl, audienceId)))
                .GET()
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == HttpStatus.NOT_FOUND.value()) {
            return null;
        }

        return gson.fromJson(response.body(), Audience.class);
    }
}
