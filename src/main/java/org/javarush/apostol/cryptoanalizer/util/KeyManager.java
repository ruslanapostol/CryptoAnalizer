package org.javarush.apostol.cryptoanalizer.util;


import org.javarush.apostol.cryptoanalizer.constants.Constants;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public class KeyManager {
    private final ConsoleView view;

    public KeyManager(ConsoleView view) {
        this.view = view;
    }

    public int getValidKey() {
        int key = view.getKeyFromUser();
        while (key < Constants.MIN_KEY_VALUE || key > Constants.MAX_KEY_VALUE) {
            view.displayError("Invalid key: The key must be between " + Constants.MIN_KEY_VALUE + " and " + Constants.MAX_KEY_VALUE + ".");
            key = view.getKeyFromUser();
        }
        return key;
    }
}

