package org.javarush.apostol.cryptoanalizer.view;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public int getKeyFromUser() {
        System.out.println("Enter the key (integer): ");
        while (!scanner.hasNextInt()) {
            scanner.next(); // Consume the invalid input
            System.out.println("Invalid input. Please enter an integer:");
        }
        return scanner.nextInt();
    }

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

