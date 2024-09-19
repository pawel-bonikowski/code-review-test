package com.sii;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

public class HttpCallHelper {


    public static String getData(String url) {
        HttpClient client = HttpClient.newBuilder()
                .build();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> data = client.send(request, responseInfo -> HttpResponse.BodySubscribers.ofString(Charset.defaultCharset()));
            return data.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
