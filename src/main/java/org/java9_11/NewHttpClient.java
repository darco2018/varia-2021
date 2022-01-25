package org.java9_11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NewHttpClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://winterbe.com"))
                .GET()
                .build();
        var client = HttpClient.newHttpClient();
        // BodyHandlers define the expected type of response body (e.g. as string, byte-array or file):
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());


        var requestAsync = HttpRequest.newBuilder()
                .uri(URI.create("https://winterbe.com"))
                .build();
        var clientAsync = HttpClient.newHttpClient();
        clientAsync.sendAsync(requestAsync, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);

        //more examples : https://winterbe.com/posts/2018/09/24/java-11-tutorial/
    }
}
