package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpStatusChecker checker = new HttpStatusChecker();
        String statusImage = checker.getStatusImage(404);
        System.out.println(statusImage);

        HttpImageStatusCli statusCli = new HttpImageStatusCli();
        statusCli.askStatus();

    }
}