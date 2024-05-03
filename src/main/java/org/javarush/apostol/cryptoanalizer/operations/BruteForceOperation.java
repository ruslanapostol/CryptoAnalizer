package org.javarush.apostol.cryptoanalizer.operations;


import org.javarush.apostol.cryptoanalizer.constants.Constants;
import org.javarush.apostol.cryptoanalizer.exception.AppException;
import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.util.FileUtil;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public class BruteForceOperation extends Operation {

    public BruteForceOperation(Caesar caesar, ConsoleView view, String inputFileName, String outputFileName) {
        super(caesar, view, inputFileName, outputFileName, 0);
    }

    @Override
    public void execute() {
        try {
            String content = FileUtil.readFile(inputFileName);
            boolean foundValidDecryption = false;
            for (int key = Constants.MIN_KEY_VALUE; key < Constants.MAX_KEY_VALUE; key++) {
                String decrypted = caesar.decrypt(content, key);
                if (isLikelyRussian(decrypted)) {
                    FileUtil.writeFile(outputFileName, decrypted);
                    view.displayMessage("Decryption successful with key = " + key);
                    foundValidDecryption = true;
                    break;
                }
            }
            if (!foundValidDecryption) {
                view.displayMessage("No successful decryption found.");
                FileUtil.writeFile(outputFileName,"No successful decryption found.");
            }
        } catch (AppException e) {
            view.displayError("Error during brute force decryption: " + e.getMessage());
        }
    }

    private boolean isLikelyRussian(String text) {
        String commonRussianLetters = "оеаинт";
        int count = 0;

        for (char c : text.toCharArray()) {
            if (commonRussianLetters.indexOf(Character.toLowerCase(c)) >= 0) {
                count++;
            }
        }
        double threshold = 0.3;
        return (double) count / text.length() > threshold;
    }
}

