package org.javarush.apostol.cryptoanalizer.view;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String error) {
        System.err.println(error);
    }

    public void close() {
        scanner.close();
    }
}

