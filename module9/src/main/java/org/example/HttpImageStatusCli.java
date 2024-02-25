package org.example;

import java.io.IOException;
import java.util.Scanner;


public class HttpImageStatusCli {

    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }

    private HttpStatusImageDownloader downloader;

    private Scanner scanner;

    public HttpImageStatusCli() {
        this.downloader = new HttpStatusImageDownloader();
        this.scanner = new Scanner(System.in);
    }

    public void askStatus() {
        System.out.println("Enter HTTP status code:");
        String input = scanner.nextLine();

        try {
            int statusCode = Integer.parseInt(input);
            if (statusCode >= 100 && statusCode <= 599) {
                try {
                    downloader.downloadStatusImage(statusCode);
                    System.out.println("Image downloaded successfully.");
                } catch (IOException e) {
                    System.out.println("There is not image for HTTP status " + statusCode);
                }
            } else {
                System.out.println("Please enter valid number");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
        }
    }
}
