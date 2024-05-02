package org.javarush.apostol.cryptoanalizer.main;


import org.javarush.apostol.cryptoanalizer.constants.Constants;
import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.operations.*;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;



public class App {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        try {
            while (true) {
                view.displayMessage("Please select mode:");
                view.displayMessage("1. Encrypt");
                view.displayMessage("2. Decrypt");
                view.displayMessage("3. Brute force");
                view.displayMessage("4. Exit");

                int choice = view.getKeyFromUser();
                Operation operation;

                switch (choice) {
                    case 1:
                        operation = new EncryptOperation(new Caesar(), view, Constants.INPUT_FILE_PATH, Constants.ENCRYPTED_FILE_PATH);
                        break;
                    case 2:
                        operation = new DecryptOperation(new Caesar(), view, Constants.ENCRYPTED_FILE_PATH, Constants.DECRYPTED_FILE_PATH);
                        break;
                    case 3:
                        operation = new BruteForceOperation(new Caesar(), view, Constants.ENCRYPTED_FILE_PATH, Constants.BRUTE_FORCE_FILE_PATH);
                        break;
                    case 4:
                        view.displayMessage("Exiting the application...");
                        return;  // Exit the loop and end the application
                    default:
                        view.displayError("Invalid option. Please enter a number between 1 and 4.");
                        continue;  // Continue the loop, prompting the user again
                }

                operation.execute();  // Execute the selected operation
            }
        } finally {
            view.close();  // Ensure resources are closed properly
        }
    }
}


