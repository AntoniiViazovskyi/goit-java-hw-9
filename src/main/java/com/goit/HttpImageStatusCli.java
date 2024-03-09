package com.goit;

import java.util.Scanner;

public class HttpImageStatusCli {

    private static final HttpStatusImageDownloader httpDownloader = new HttpStatusImageDownloader();
    private static final HttpStatusChecker statusChecker = new HttpStatusChecker();
    private static final Scanner scanner = new Scanner(System.in);

    public void askStatus() {

            System.out.println("Enter HTTP status code:");
            int inputCode = scanner.nextInt();
            int checkedInputCode = checkCorrectInput(inputCode);
            httpDownloader.downloadStatusImage(checkedInputCode);
    }

    private int checkCorrectInput(int code)  {
        int result = 0;
        boolean correctInput = false;
        while (!correctInput) {
            try {
                statusChecker.getStatusImage(code);
                result = code;
                correctInput = true;
            } catch (IllegalHttpCodeException e) {
                System.out.println("ERROR! Incorrect http code. \nPlease enter valid code:");
                code = scanner.nextInt();
            }
        }
        return result;
    }

}
