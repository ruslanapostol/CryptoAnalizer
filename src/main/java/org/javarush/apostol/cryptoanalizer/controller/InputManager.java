package org.javarush.apostol.cryptoanalizer.controller;

import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

import java.util.Scanner;

public class InputManager {
    private final ConsoleView view;
    private final Scanner scanner;

    public InputManager(ConsoleView view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }

    public String getInputFilePath(String prompt, String defaultPath) {
        view.displayMessage(prompt);
        String path = scanner.nextLine().trim();
        return path.isEmpty() ? defaultPath : path;
    }

    public String getOutputFilePath(String prompt, String defaultPath) {
        view.displayMessage(prompt);
        String path = scanner.nextLine().trim();
        return path.isEmpty() ? defaultPath : path;
    }

    public int getKey(String prompt, int defaultKey) {
        view.displayMessage(prompt);
        String keyInput = scanner.nextLine().trim();
        try {
            return keyInput.isEmpty() ? defaultKey : Integer.parseInt(keyInput);
        } catch (NumberFormatException e) {
            view.displayMessage("Invalid key format. Using default key=" + defaultKey);
            return defaultKey;
        }
    }
}

