package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class HttpStatusImageDownloader {

    public static void main(String[] args) {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        try {
            downloader.downloadStatusImage(200);
            downloader.downloadStatusImage(404);
            downloader.downloadStatusImage(666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private OkHttpClient httpClient;

    public HttpStatusImageDownloader() {
        this.httpClient = new OkHttpClient();
    }

    public void downloadStatusImage(int code) throws IOException {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);

        Request request = new Request.Builder()
                .url(imageUrl)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            try (InputStream inputStream = response.body().byteStream();
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                 FileOutputStream fileOutputStream = new FileOutputStream(code + ".jpg")) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
            }
        }
    }
}