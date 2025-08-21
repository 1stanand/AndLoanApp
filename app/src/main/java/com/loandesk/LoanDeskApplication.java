package com.loandesk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoanDeskApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Username: ");
        String username = reader.readLine();
        System.out.print("Password: ");
        String password = reader.readLine();
        System.out.println("Received credentials - username: " + username + ", password: " + password);
    }
}