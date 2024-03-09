package com.goit;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpStatusImageDownloader {

    private static final HttpStatusChecker statusChecker = new HttpStatusChecker();
    private static final String mainAddress = "src/main/resources/";

    public void downloadStatusImage(int code) {
        HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();

        HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(statusChecker.getStatusImage(code)))
                    .GET()
                    .build();

        try {
            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
            String address = mainAddress + code + ".jpg";
            Files.write(Path.of(address), response.body());
            System.out.println("Image was downloaded");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

