package org.javarush.apostol.cryptoanalizer.operations;


import org.javarush.apostol.cryptoanalizer.constants.Constants;
import org.javarush.apostol.cryptoanalizer.exception.AppException;
import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.util.FileUtil;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public class BruteForceOperation extends Operation {

    public BruteForceOperation(Caesar caesar, ConsoleView view, String inputFileName, String outputFileName) {
        super(caesar, view, inputFileName, outputFileName);
    }

    @Override
    public void execute() {
        try {
            String content = FileUtil.readFile(inputFileName);
            boolean decryptionSuccessful = false;
            for (int key = 1; key < 42; key++) {
                String decrypted = caesar.decrypt(content, key);
                if (isLikelyRussian(decrypted)) {
                    FileUtil.writeFile(outputFileName, decrypted);
                    view.displayMessage("Decryption successful with key = " + key);
                    view.displayMessage("Decrypted text saved to " + outputFileName);
                    decryptionSuccessful = true;
                    break;
                }
            }

            if (!decryptionSuccessful) {
                view.displayMessage("Decryption failed");
            }
        } catch (AppException e) {
            view.displayError("Error: " + e.getMessage());
        }
    }

    private boolean isLikelyRussian(String text) {
        String commonChars = "оеаинт";
        double threshold = 0.3;
        int count = 0;

        for (char c : text.toCharArray()) {
            if (commonChars.indexOf(c) >= 0) {
                count++;

            }
        }

        return (double) count / text.length() > threshold;
    }
}

