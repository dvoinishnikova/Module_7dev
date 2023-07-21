package org.example;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws IOException {
        String directoryPath = "./src/main/resources/";
        String fileName = code + ".jpg";
        String filePath = directoryPath + fileName;
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try (InputStream in = new BufferedInputStream(connection.getInputStream());
             FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        }
        System.out.println("Image downloaded successfully!");
    }
}
