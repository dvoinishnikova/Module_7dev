package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(("Enter HTTP status code"));
        int code = 0;

        try {
            code = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Please enter valid number");
            askStatus();
        }finally {
            scanner.close();
        }
        try {
            new HttpStatusImageDownloader().downloadStatusImage(code);
        }catch (Exception e){
            System.out.println("There is not image for HTTP status "+ code);
        }
    }
}