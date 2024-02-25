package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class HttpStatusChecker {

    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();

        try {
            System.out.println(checker.getStatusImage(200));
            System.out.println(checker.getStatusImage(404));
            System.out.println(checker.getStatusImage(666));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private OkHttpClient httpClient;

    public HttpStatusChecker() {
        this.httpClient = new OkHttpClient();
    }

    public String getStatusImage(int code) throws IOException {
        String url = "https://http.cat/" + code + ".jpg";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return url;
        }
    }
}